package com.rockwellcollins.spear.utilities;

import java.util.Set;
import java.util.TreeSet;

public class LustreUtilities {
	
	public static Set<String> getLustreKeywordSet() {
		Set<String> keywords = new TreeSet<>();
		keywords.add("then");
		keywords.add("type");
		keywords.add("pre");
		keywords.add("struct");
		keywords.add("true");
		keywords.add("else");
		keywords.add("tel");
		keywords.add("condact");
		keywords.add("let");
		keywords.add("and");
		keywords.add("var");
		keywords.add("floor");
		keywords.add("int");
		keywords.add("if");
		keywords.add("not");
		keywords.add("of");
		keywords.add("subrange");
		keywords.add("real");
		keywords.add("enum");
		keywords.add("assert");
		keywords.add("returns");
		keywords.add("mod");
		keywords.add("const");
		keywords.add("div");
		keywords.add("bool");
		keywords.add("xor");
		keywords.add("false");
		keywords.add("node");
		keywords.add("or");
		
		//these aren't Lustre keywords, but ones we're reserving for the translation
		keywords.add("initially");
		keywords.add("once");
		keywords.add("historically");
		keywords.add("since");
		keywords.add("triggers");
		keywords.add("responds_within");
		return keywords;
	}
}
