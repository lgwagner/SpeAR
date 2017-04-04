package com.rockwellcollins.spear.ui.commandline;

import com.beust.jcommander.Parameters;

/*
-excel           generate results in Excel format
-extend_cex      report extend counterexample
-help            print this message
-n <arg>         number of iterations (default 200)
-reduce          reduce conflicting properties in case of unrealizable
-scratch         produce files for debugging purposes
-timeout <arg>   maximum runtime in seconds (default 100)
-version         display version information
-xml             generate results in XML format
*/
@Parameters(commandDescription = "Attempts to prove that an implementation can be given for the requirements under " +
                                 "the assumptions.")
class SpeARjRealizabilityCommandRealizability {
}