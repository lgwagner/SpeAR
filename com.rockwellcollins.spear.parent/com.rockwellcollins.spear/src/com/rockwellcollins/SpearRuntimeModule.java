/*
 * Information: Initially generated by Xtext 2.18.0.M3
 */
package com.rockwellcollins;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.rockwellcollins.spear.naming.SpearDeclarativeQualifiedNameProvider;
import com.rockwellcollins.validation.IValidatorAdvisor;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SpearRuntimeModule extends AbstractSpearRuntimeModule {

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ImportUriGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SpearDeclarativeQualifiedNameProvider.class;
	}

	public Class<? extends IValidatorAdvisor> bindIValidatorAdvisor() {
		return VacuousValidator.class;
	}
}