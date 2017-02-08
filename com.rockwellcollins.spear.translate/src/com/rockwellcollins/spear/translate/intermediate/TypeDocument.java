package com.rockwellcollins.spear.translate.intermediate;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.language.Create;
import com.rockwellcollins.spear.optional.OptionalExpr;
import com.rockwellcollins.spear.optional.SomeExpr;
import com.rockwellcollins.spear.translate.transformations.PerformTransforms;
import com.rockwellcollins.spear.translate.utilities.EmitPredicateProperties;

public class TypeDocument extends Document {
	
	public Pattern pattern;
	
	public TypeDocument(TypeDef top) {
		this.mainName=top.getName();
		for(EObject e : FindTypeDependencies.instance(top)) {
			if (e instanceof TypeDef) {
				TypeDef td = (TypeDef) e;
				typedefs.put(td.getName(), td);
			}
		}
		this.pattern = createPattern();
	}
	
	public TypeDef getMain() {
		return this.typedefs.get(this.mainName);
	}
	
	
	//FIXME: Refactor please.
	private Pattern createPattern() {
		Pattern p = Create.createPattern(this.mainName + "_tcc");
		
		TypeDef main = this.getMain();
		Variable in = Create.createVariable("in", Create.createUserType(main));
		p.getInputs().add(in);
		
		Variable vacuous = Create.createBoolVariable(main.getName() + "_valid");
		p.getOutputs().add(vacuous);
		
		OptionalExpr oe = EmitPredicateProperties.crunch(in);
		if (oe instanceof SomeExpr) {
			SomeExpr some = (SomeExpr) oe;
			p.getEquations().add(Create.createLustreEquation(Collections.singletonList(vacuous),Create.createNot(some.expr)));
		} else {
			p.getEquations().add(Create.createLustreEquation(Collections.singletonList(vacuous),Create.createTrue()));
		}
		
		p.getProperties().add(Create.createLustreProperty(vacuous));
		
		return p;
	}

	public void transform() {
		try {
			this.renamed = PerformTransforms.apply(this);
		} catch (Exception e) {
			System.err.println("Error performing transformations.");
			e.printStackTrace();
			System.exit(-1);
		}		
	}

	public PatternDocument toPatternDocument() {
		return new PatternDocument(this);
	}
}
