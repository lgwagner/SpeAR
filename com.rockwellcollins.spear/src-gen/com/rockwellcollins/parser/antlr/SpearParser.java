/*
* generated by Xtext
*/
package com.rockwellcollins.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import com.rockwellcollins.services.SpearGrammarAccess;

public class SpearParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private SpearGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected com.rockwellcollins.parser.antlr.internal.InternalSpearParser createParser(XtextTokenStream stream) {
		return new com.rockwellcollins.parser.antlr.internal.InternalSpearParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "File";
	}
	
	public SpearGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SpearGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
