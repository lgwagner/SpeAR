package com.rockwellcollins.spear.ui.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.ui.internal.SpearActivator;

public class ActionUtilities {
	
	public static boolean hasErrors(Resource res) {
		Injector injector = SpearActivator.getInstance().getInjector(SpearActivator.COM_ROCKWELLCOLLINS_SPEAR);
		IResourceValidator resourceValidator = injector.getInstance(IResourceValidator.class);

		for (Issue issue : resourceValidator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl)) {
			if (issue.getSeverity() == Severity.ERROR) {
				return true;
			}
		}
		return false;
	}
	
	public static String getGeneratedFile(URI baseURI, String extension) {
		String filename = baseURI.lastSegment();
		int i = filename.lastIndexOf(".");
		String newFilename = filename.substring(0, i) + "." + extension;
		return newFilename;
	}
	
	public static URI createURI(URI folder, String filename) {
		folder = folder.appendSegment(filename);
		return folder;
	}
	
	public static URI createFolder(URI baseURI, String folder) {
		baseURI = baseURI.trimSegments(1);
		baseURI = baseURI.appendSegment(folder);
		return baseURI;
	}

	public static boolean makeFolder(IFolder f) throws IOException {
		return f.getRawLocation().toFile().mkdir();
	}
	
	public static void printResource(IResource res, String contents) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res.getRawLocation().toFile()))) {
			bw.write(contents);
		}
	}
	
	public static boolean checkForDot() {
		ProcessBuilder pb = new ProcessBuilder("dot","-?");
		try {
			pb.start().waitFor();
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}
