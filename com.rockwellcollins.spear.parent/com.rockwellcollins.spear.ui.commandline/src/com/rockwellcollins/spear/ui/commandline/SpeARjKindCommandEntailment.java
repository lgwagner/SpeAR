package com.rockwellcollins.spear.ui.commandline;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Attempts to prove that properties follow from requirements and assumptions.")
class SpeARjKindCommandEntailment extends SpeARjKindCommand {
	@Parameter(names = "-ivc", description = "Find an inductive validity core for valid properties "
			+ "(based on --%IVC annotated elements).")
	public boolean ivc = false;
}