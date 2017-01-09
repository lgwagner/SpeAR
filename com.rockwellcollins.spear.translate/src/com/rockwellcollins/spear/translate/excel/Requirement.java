package com.rockwellcollins.spear.translate.excel;

import java.util.ArrayList;
import java.util.List;

import jkind.Assert;

public class Requirement {
	private final String id;
	private final String text;
	private final String type;
	private final String owner;
	private final String component;
	private List<String> parentList = new ArrayList<>();
	private List<String> childList = new ArrayList<>();  
	private final String reviewDate;
	private final String source;
	private final String rationale;
	private final String comments;
    
	public Requirement(String id, String text, String type, String owner, String component,
			List<String> parentList, 
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
	
	public String getID(){
		return id;
	}
	
	public List<String> getParentList(){
		return parentList;
	}
	
	public List<String> getChildList(){
		return childList;
	}
	
	public void addChild(String childID){
		childList.add(childID);
	}
	

}
