package com.rockwellcollins.spear.translate.layout;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jkind.api.results.MapRenaming;

public class SpearRenaming extends MapRenaming {
	public SpearRenaming(Map<String, String> map) {
		super(map, Mode.IDENTITY);
	}

	@Override
	public String rename(String original) {
		List<String> parts = splitPreserveDelimeters(original, "\\.|\\[\\d+\\]");
		return parts.stream().map(s -> super.rename(s)).collect(joining(""));
	}
	
	public List<String> splitPreserveDelimeters(String text, String regex) {
		Matcher matcher = Pattern.compile(regex).matcher(text);
		List<String> result = new ArrayList<>();
		
		int prev = 0;
		while (matcher.find()) {
			result.add(text.substring(prev, matcher.start()));
			result.add(text.substring(matcher.start(), matcher.end()));
			prev = matcher.end();
		}
		
		result.add(text.substring(prev));

		return result;
	}
}
