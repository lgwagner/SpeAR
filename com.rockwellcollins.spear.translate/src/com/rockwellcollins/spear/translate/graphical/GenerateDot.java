package com.rockwellcollins.spear.translate.graphical;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.Import;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.PatternCall;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.SpecificationCall;
import com.rockwellcollins.spear.preferences.PreferencesUtil;
import com.rockwellcollins.spear.utilities.Utilities;

public class GenerateDot {

	public static String generateDot(Specification main) {
		GenerateDot generate = new GenerateDot(main);
		generate.generate();
		return generate.buffer.toString();
	}

	private final static String firstline = "digraph G {";
	private final static String lastline = "}";
	private final static String newline = "\n";
	private final static String spacedArrow = " -> ";

	private Specification main;
	private StringBuffer buffer;

	private Set<EObject> defined = new HashSet<>();

	private GenerateDot(Specification s) {
		this.main = s;
		this.buffer = new StringBuffer();
	}

	private void generate() {
		buffer.append(firstline + newline);
		this.generateSpec(main);
		buffer.append(lastline);
	}

	private void generateSpec(Specification s) {
		buffer.append(s.getName() + " [label=\"" + s.getName() + "\"]" + newline);
		defined.add(s);

		for (Import im : s.getImports()) {
			File imported = Utilities.getImportedFile(im);
			if (imported instanceof Definitions) {
				Definitions def = (Definitions) imported;
				if (!defined.contains(def)) {
					defined.add(def);
					buffer.append(def.getName() + "[shape=polygon,sides=4,label=\"" + def.getName() + "\"]" + newline);
				}
				buffer.append(def.getName() + spacedArrow + s.getName() + newline);
			}
		}

		for (SpecificationCall call : EcoreUtil2.getAllContentsOfType(s, SpecificationCall.class)) {
			Specification called = call.getSpec();
			buffer.append(s.getName() + spacedArrow + called.getName() + newline);
			if (!defined.contains(called) && PreferencesUtil.getRecursiveGraphicalDisplayOption()) {
				this.generateSpec(called);
			}
		}

		List<PatternCall> calls = this.getDirectPatternCalls(s);
		for (PatternCall call : calls) {
			Pattern called = call.getPattern();
			buffer.append(s.getName() + spacedArrow + called.getName() + newline);
			if (!defined.contains(called)) {
				generatePattern(called);
			}
		}
	}

	private void generatePattern(Pattern p) {
		buffer.append(p.getName() + " [shape=polygon,sides=6,label=\"" + p.getName() + "\"]" + newline);
		defined.add(p);

		if (PreferencesUtil.getRecursiveGraphicalDisplayOption()) {
			for (PatternCall call : EcoreUtil2.getAllContentsOfType(p, PatternCall.class)) {
				Pattern called = call.getPattern();
				buffer.append(p.getName() + spacedArrow + called.getName() + newline);
				if (!defined.contains(called)) {
					this.generatePattern(called);
				}
			}
		}
	}

	// we need to filter out the pattern calls that exist inside of other
	// patterns
	// in a spec
	private List<PatternCall> getDirectPatternCalls(Specification s) {

		List<PatternCall> patternCalls = EcoreUtil2.getAllContentsOfType(s, PatternCall.class);
		List<PatternCall> filtered = patternCalls.stream().filter(pc -> Utilities.getTopContainer(pc).equals(s))
				.collect(Collectors.toList());
		return filtered;
	}
}
