package com.rockwellcollins.spear.ui.commandline;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Arguments {

  public static Arguments parse(String[] cmdlineargs) {
    Arguments arguments = new Arguments();
    ;
    JCommander jcom = new JCommander(arguments);
    jcom.addCommand("entailment", new SpeARjKindCommandEntailment());
    jcom.addCommand("consistency", new SpeARjKindCommandConsistency());
    jcom.addCommand("realizability", new SpeARjRealizabilityCommandRealizability());
    
    try {
      jcom.parse(cmdlineargs);
      if(jcom.getParsedCommand() == null) {
        throw new ParameterException("A command must be given.");
      }
    } catch (ParameterException pe) {
      System.err.println(pe.getMessage());
      jcom.usage();
      return null;
    }
    return arguments;
  }
}
