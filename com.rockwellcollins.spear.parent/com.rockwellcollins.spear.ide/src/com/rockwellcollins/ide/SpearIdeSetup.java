/*
 * generated by Xtext 2.14.0
 */
package com.rockwellcollins.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rockwellcollins.SpearRuntimeModule;
import com.rockwellcollins.SpearStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class SpearIdeSetup extends SpearStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new SpearRuntimeModule(), new SpearIdeModule()));
	}
	
}
