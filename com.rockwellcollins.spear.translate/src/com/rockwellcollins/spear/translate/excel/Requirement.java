package com.rockwellcollins.spear.translate.excel;

import java.util.ArrayList;
import java.util.List;

import jkind.Assert;

public class Requirement {
	public final String id;
	public final String text;
    public final String type;
	public final String owner;
	public final String component;
    public List<String> parentList = new ArrayList<>();
    public List<String> childList = new ArrayList<>();  
    public final String reviewDate;
    public final String source;
    public final String rationale;
    public final String comments;
    
	public Requirement(String id, String text, String type, String owner, String component,
			List<String> parentList, List<String> childList, 
			String reviewDate, String source, String rationale, String comments) {
		Assert.isNotNull(id);
		Assert.isNotNull(text);
		Assert.isNotNull(type);		
		Assert.isNotNull(owner);
		Assert.isNotNull(component);
		this.id = id;
		this.text = text;
		this.type = type;
		this.owner = owner;
		this.component = component;
		this.parentList = parentList;
		this.childList = childList;
		this.reviewDate = reviewDate;
		this.source = source;
		this.rationale = rationale;
		this.comments = comments;
	}
	
	public List<String> exportStrs() {
		List<String> attributeList = new ArrayList<>();
		attributeList.add(id);
		attributeList.add(text);
		attributeList.add(type);
		attributeList.add(owner);
		attributeList.add(component);
		attributeList.add(String.join(", ", parentList));
		attributeList.add(String.join(", ", childList));		
		attributeList.add(reviewDate);
		attributeList.add(source);
		attributeList.add(rationale);
		attributeList.add(comments);
		return attributeList;
	}
}
