package com.rockwellcollins.spear.translate.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.rockwellcollins.spear.CommentsData;
import com.rockwellcollins.spear.Constraint;
import com.rockwellcollins.spear.Data;
import com.rockwellcollins.spear.DescriptionData;
import com.rockwellcollins.spear.EnglishConstraint;
import com.rockwellcollins.spear.FormalConstraint;
import com.rockwellcollins.spear.OwnerData;
import com.rockwellcollins.spear.RationaleData;
import com.rockwellcollins.spear.ReviewData;
import com.rockwellcollins.spear.SourceData;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.util.SpearSwitch;

import com.rockwellcollins.spear.translate.excel.Requirement;

public class MakeExcel extends SpearSwitch<Integer> {

    public static List<Requirement> requirementList = new ArrayList<>();
	
	public static void toExcel(Specification s, File f) throws Exception {
		try (ExcelFormatter formatter = new ExcelFormatter(f)) {
			//formatter.writeCounterexample("Requirements", this, Collections.emptyList());
			new MakeExcel(s,f);
			//need to connect writeRequirements with file
			formatter.writeSpecification(requirementList);
			//need to handle the situation when the file is already open - then it cannot be launched 
			org.eclipse.swt.program.Program.launch(f.toString());
		}
		//new MakeExcel(s,f);
	}
	
	private void exportRequirement(Iterator<Constraint> constraintIterator, String type) throws Exception{
		
		while (constraintIterator.hasNext()) {
			//get current constraint
			Constraint curConstraint = constraintIterator.next();
			//set flag for export
			boolean export = false;
			
			//initialize the attributes
			String id = curConstraint.getName();
			
			String text = "";
			String owner = "";
			String component = "";
			String reviewDate = "";
			String source = "";
			String rationale = "";
			String comments = "";
	        List<String> parentList = new ArrayList<>();
	        List<String> childList = new ArrayList<>();	    

	        //extract data from the current constraint and update the attributes
	        
			//if EnglishConstraint
			if (curConstraint instanceof EnglishConstraint){
				text = ((EnglishConstraint)curConstraint).getText();	
				export = true;
			}
			
			//to-do: populate parent list
			//Data:
			//| {TraceData} ('trace' | 'parents') '=' '[' ids+=ID (',' ids+=ID)* ']'
			//to-do: populate child list
			//to-do: populate component
				
			EList<Data> dataList = curConstraint.getData();
			Iterator<Data> dataIterator = dataList.iterator();
			while(dataIterator.hasNext()){
				Data curData = dataIterator.next();
				if(curData instanceof DescriptionData){
					text = detectDuplicates(id, type, "text", text, curData);
				}
				else if(curData instanceof OwnerData){
					owner = detectDuplicates(id, type, "owner", owner, curData);
				}
				else if(curData instanceof ReviewData){
					reviewDate = detectDuplicates(id, type, "reviewDate", reviewDate, curData);
				}
				else if(curData instanceof SourceData){
					source = detectDuplicates(id, type, "source", source, curData);
				}
				else if(curData instanceof RationaleData){
					rationale = detectDuplicates(id, type, "rationale", rationale, curData);
				}
				else if(curData instanceof CommentsData){
					comments = detectDuplicates(id, type, "comments", comments, curData);
				}
			}
			
			//if FormalConstraint and empty text, no export
			if (curConstraint instanceof FormalConstraint){
				if("".equals(text)){
					export = false;
				}
				else{
					export = true;
				}
			}
			
			if(export){
				//create requirement instance
				Requirement curRequirement = new Requirement(id, text, type, owner, component, parentList, childList, 
						reviewDate, source, rationale, comments);
				//add to requirement list
				requirementList.add(curRequirement);
			}
		}
	}
	
	public MakeExcel(Specification s, File f) throws Exception{
		//get the assumptions
		Iterator<Constraint> asIterator = s.getAssumptions().iterator();
		exportRequirement(asIterator, "ASSUMPTION");	
		//get the requirements
		Iterator<Constraint> reqIterator = s.getRequirements().iterator();
		exportRequirement(reqIterator, "REQT");
		//get the properties
		Iterator<Constraint> propIterator = s.getBehaviors().iterator();
		exportRequirement(propIterator, "PROP");		
	}

	private String detectDuplicates(String id, String type, String attributeName, String text, Data curData) throws Exception {
		if("".equals(text)){
			text = curData.getString();
		}else{
			throw new Exception("Duplicate "+attributeName+" for "+type+ " ID "+id);
		}
		return text;
	}

}
