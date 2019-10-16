package com.rockwellcollins;

import com.google.inject.Injector;

public class SpearInjectorUtil {

	private static Injector injector;

	public static void setInjector(Injector injector) {
		SpearInjectorUtil.injector = injector;
	}

	public static void doStandaloneSetup() {
		injector = new SpearStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static <T> T getInstance(Class<T> type) {
		if (injector == null) {
			throw new IllegalArgumentException("InjectorUtil must be initialized correctly");
		}
		return injector.getInstance(type);
	}
}
