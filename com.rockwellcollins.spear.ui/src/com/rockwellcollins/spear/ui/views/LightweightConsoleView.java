package com.rockwellcollins.spear.ui.views;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class LightweightConsoleView extends ViewPart {

  public static final String ID = "com.rockwellcollins.spear.ui.views.LightweightConsoleView";

  public List list;
  
  public void createPartControl(Composite parent) {
    
    parent.setLayout(new GridLayout());

    list = new List(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);

    list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite container = new Composite(parent, SWT.NONE);
    container.setLayout(new FillLayout());
  
  }

  public void setFocus() {
   list.setFocus();
  }
 }