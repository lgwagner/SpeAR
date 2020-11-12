package com.rockwellcollins.ui.syntaxcoloring;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class SpearAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_EXT_INT".equals(tokenName)) {
			return HighlightingStyles.NUMBER_ID;
		}
		return super.calculateId(tokenName, tokenType);
	}
}
