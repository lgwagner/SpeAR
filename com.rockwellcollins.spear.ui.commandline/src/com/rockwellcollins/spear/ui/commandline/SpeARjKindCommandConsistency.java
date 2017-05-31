package com.rockwellcollins.spear.ui.commandline;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Attempts to prove absurdity does not follow from requirements and assumptions.")
class SpeARjKindCommandConsistency extends SpeARjKindCommand {
	@Parameter(names = "-con_depth", description = "Maximum depth for bmc and k-induction.", arity = 1)
	public Integer con_depth = 10;
}