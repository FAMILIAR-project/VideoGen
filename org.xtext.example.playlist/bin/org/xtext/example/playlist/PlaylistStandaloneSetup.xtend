/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.playlist

import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class PlaylistStandaloneSetup extends PlaylistStandaloneSetupGenerated {

	def static void doSetup() {
		new PlaylistStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
