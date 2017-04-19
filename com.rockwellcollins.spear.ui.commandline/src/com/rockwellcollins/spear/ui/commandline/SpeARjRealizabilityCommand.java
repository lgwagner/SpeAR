package com.rockwellcollins.spear.ui.commandline;

import java.util.List;
import java.io.File;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;

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
class SpeARjRealizabilityCommand {
  
  @Parameter(description = "file", required = true, converter = FileConverter.class)
  public List<File> spec;
  
  //@Parameter(names = "-extend_cex", description = "Report extend counterexample.")
  //public boolean extend_cex = false;
  
  @Parameter(names = "-n", description = "Maximum depth for bmc and k-induction.", arity = 1)
  public Integer n = 200;
  
  //@Parameter(names = "-reduce", description = "Reduce conflicting properties in case of unrealizable.")
  //public boolean reduce = false;
  
  @Parameter(names = "-lustre", description = "Produce lustre file corresponding to the input model in the same directory of the model.")
  public boolean lustre = false;
  
  @Parameter(names = "-timeout", description = "Maximum runtime in seconds.", arity = 1)
  public Integer timeout = 100;
}