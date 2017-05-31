package com.rockwellcollins.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

public class SpearEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Override
	protected String getFirstLine(EObject o) {
		String name = SimpleAttributeResolver.NAME_RESOLVER.apply(o);
		if (name != null) {
			return name;
		} else {
			System.out.println("ya done messed up.");
			return o.toString();
		}
	}

}
