package com.rockwellcollins.spear.ui.handlers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.javatuples.Pair;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rockwellcollins.SpearRuntimeModule;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.analysis.Analysis;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.ui.actions.ActionUtilities;

import jkind.api.results.JKindResult;
import jkind.api.results.PropertyResult;
import jkind.api.results.Status;

public class BatchAnalysis extends AbstractHandler {

  private XtextResourceSet resourceSet;
  private MessageConsole console;
  private MessageConsoleStream consoleOutput;
  private Thread ba = null;
  public BatchAnalysis() {
    Injector injector = Guice.createInjector(new SpearRuntimeModule());
    resourceSet = injector.getInstance(XtextResourceSet.class);
    resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
    console = new MessageConsole("Batch Analysis", null);
    consoleOutput = console.newMessageStream();
    ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
    ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
  }
  
  private void message(IFile ifile, String msg) {
    consoleOutput.println(ifile.getFullPath().toString() + " : " + msg);
  }
  
  @Override
  public Object execute(ExecutionEvent event) {
    if(ba != null && ba.getState() != Thread.State.TERMINATED) {
      MessageDialog dialog = new MessageDialog(null, "Batch Analysis Error", null,
          "Batch Analysis already running!", MessageDialog.ERROR, new String[] { "ok" }, 0);
      int result = dialog.open();
      return null;
    }
    ba = new Thread(() -> { try {
      work(event);
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } });
    ba.start();
    return null;
  }

  private Object work(ExecutionEvent event) throws ExecutionException {
    
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
    IWorkbenchPage activePage = window.getActivePage();
    ISelection selection = activePage.getSelection();
    if (selection != null) {
      if (selection instanceof IStructuredSelection) {
        IStructuredSelection sselection = (IStructuredSelection) selection;
        List<Object> models = new LinkedList<>();
        for( Object o : sselection.toArray()) {
          findSpearModels(o,models);
        }
        for(Object o : models) {
          IFile ifile = (IFile) o;
          URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
          Resource resource = resourceSet.getResource(uri, true);
          XtextResource xtextResource = (XtextResource) resource;
          File file = (File) xtextResource.getContents().get(0);
          if (file instanceof Definitions) {
            continue;
          }
          Specification specification = (Specification) file;
          // check the spec and imported files for errors
          if(ActionUtilities.hasErrors(specification.eResource())) {
            message(ifile,"Errors detected, skipping analysis.");
            continue;
          }

          if (specification.getBehaviors().size() > 0) {
            Pair<Analysis, JKindResult> pair;
            try {
              pair = Analysis.entailment(specification, PreferencesUtil.getJKindJar(), "result");
              pair.getValue0().analyze(new NullProgressMonitor());
              for( PropertyResult result : pair.getValue1().getPropertyResults()) {
                if(Status.VALID != result.getStatus()) {
                  message(ifile,"The property " + result.getName() + " failed during entailment analysis.");
                }
              }
            } catch (Exception e) {
              message(ifile,"Entailment analysis failed.");
            }
          } else {
            message(ifile,"No behaviors found, skipping entailment analysis.");
          }
          
          if (true){ 
            Pair<Analysis, JKindResult> pair;
            try {
            pair = Analysis.consistency(specification, PreferencesUtil.getJKindJar(), "result");
            pair.getValue0().analyze(new NullProgressMonitor());
            for( PropertyResult result : pair.getValue1().getPropertyResults()) {
              if(Status.VALID != result.getStatus()) {
                message(ifile,"The property " + result.getName() + " failed during consistency analysis.");
              }
            }
            } catch (Exception e) {
              message(ifile,"Consistency analysis failed.");
            }
          }
          
          if (specification.getBehaviors().size() > 0) {
            Pair<Analysis, JKindResult> pair;
            try {
            pair = Analysis.realizability(specification, PreferencesUtil.getJKindJar(), "result");
            pair.getValue0().analyze(new NullProgressMonitor());
           
              for( PropertyResult result : pair.getValue1().getPropertyResults()) {
                if(Status.VALID != result.getStatus()) {
                  message(ifile,"The property " + result.getName() + " failed during realizability analysis.");
                }
              }
            } catch (Exception e) {
              message(ifile,"Realizability analysis failed.");
            }
          } else {
            message(ifile,"No behaviors found, skipping realizability analysis.");
          }
          
        }
      }
      try {
        ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      } catch (Exception e){
        throw new ExecutionException("Error while refreshing workspace : " + e.toString());
      }
    }
    return null;
  }
  
  private void findSpearModels(Object o, List<Object> models) {
    if(o != null && o instanceof IContainer) {
      try {
        for(IResource r: ((IContainer)o).members()) {
          if(r instanceof IFile) {
            if(((IFile)r).getFileExtension().compareTo("spear") == 0) {
              models.add(r);
            }
          } else {
            findSpearModels(r,models);
          }
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (o instanceof IFile) {
      System.out.println(o);
      if(((IFile)o).getFileExtension().compareTo("spear") == 0)
        models.add(o);
      }
    }

}
