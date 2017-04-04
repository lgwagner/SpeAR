package com.rockwellcollins.spear.ui.commandline;

import java.io.File;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.FileConverter;

enum SolverEnum {
  SMTINTERPOL,
  Z3,
  YICES,
  YICES2,
  CVC4,
  MATHSAT;
  // converter that will be used later
  public static SolverEnum fromString(String code) {
      for(SolverEnum output : SolverEnum.values()) {
          if(output.toString().equalsIgnoreCase(code)) {
              return output;
          }
      }
      return null;
  }
}

class SolverConverter implements IStringConverter<SolverEnum> {
 
    @Override
    public SolverEnum convert(String value) {
      SolverEnum convertedValue = SolverEnum.fromString(value);
 
        if(convertedValue == null) {
            throw new ParameterException("Invalid solver " + value +
                ". Valid options are: smtinterpol, z3, yices, yices2, cvc4, mathsat.");
        }
        return convertedValue;
    }
}

public class SpeARjKindCommand {
  @Parameter(description = "[SpeAR specification file]", converter = FileConverter.class)
  public File spec;
  
  @Parameter(names = "-induct_cex", description = "Generate inductive counterexamples.")
  public boolean induct_cex = false;

  @Parameter(names = "-interval", description = "Generalize counterexamples using interval analysis.")
  public boolean interval = false;
  
  @Parameter(names = "-ivc", description = "Find an inductive validity core for valid properties " +
                    "(based on --%IVC annotated elements).")
  public boolean ivc = false;
  
  @Parameter(names = "-main", description = "Specify main node (overrides --%MAIN).", arity = 1)
  public String main = null;
  
  @Parameter(names = "-n", description = "Maximum depth for bmc and k-induction.", arity = 1)
  public Integer n = 200;
  
  @Parameter(names = "-no_bmc", description = "Disable bounded model checking.")
  public boolean no_bmc = false;
  
  @Parameter(names = "-no_inv_gen", description = "Disable invariant generation.")
  public boolean no_inv_gen = false;

  @Parameter(names = "-no_k_induction", description = "Disable k-induction.")
  public boolean no_k_induction = false;
  
  @Parameter(names = "-no_slicing", description = "Disable slicing.")
  public boolean no_slicing = false;
  
  @Parameter(names = "-pdr_max", description = "Maximum number of PDR parallel instances " +
    "(0 to disable PDR).", arity = 1)
  public Integer pdr_max = 1;

  @Parameter(names = "-read_advice", description = "Read advice from specified file.", arity = 1,
      converter = FileConverter.class)
  public File read_advice = null;
  
  @Parameter(names = "-scratch", description = "Produce files for debugging purposes.")
  public boolean scratch = false;
  
  @Parameter(names = "-smooth", description = "Smooth counterexamples (minimal changes in input values).")
  public boolean smooth = false;
  
  @Parameter(names = "-solver", description = "SMT solver (alternatives: z3, yices, yices2, " + 
      " cvc4, mathsat)", arity = 1,
      converter = SolverConverter.class)
  public SolverEnum solver = SolverEnum.SMTINTERPOL;
  
  @Parameter(names = "-timeout", description = "Maximum runtime in seconds.", arity = 1)
  public Integer timeout = 100;
  
  @Parameter(names = "-write_advice", description = "Write advice to specified file.", arity = 1,
      converter = FileConverter.class)
  public File write_advice = null;

  
}