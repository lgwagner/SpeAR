package com.rockwellcollins.spear.translate.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.rockwellcollins.spear.TraceData;
import com.rockwellcollins.spear.util.SpearSwitch;

public class MakeExcel extends SpearSwitch<Integer> {

	public static HashMap<String, Requirement> reqIDMap = new HashMap<String, Requirement>();
	public static List<String> topLevelReqList = new ArrayList<>();

	public static void toExcel(Specification s, File f) throws Exception {
		try (ExcelFormatter formatter = new ExcelFormatter(f)) {
			new MakeExcel(s, f);
			// need to connect writeRequirements with file
			formatter.writeSpecification(topLevelReqList, reqIDMap);
			// need to handle the situation when the file is already open - then
			// it cannot be launched
			org.eclipse.swt.program.Program.launch(f.toString());
		}
	}

	private void exportRequirement(Iterator<Constraint> constraintIterator, String type, String compName)
			throws Exception {

		while (constraintIterator.hasNext()) {
			// get current constraint
			Constraint curConstraint = constraintIterator.next();
			// set flag for export
			boolean export = false;

			// initialize the attributes
			String id = curConstraint.getName();
			String component = compName;

			String text = "";
			String owner = "";
			String reviewDate = "";
			String source = "";
			String rationale = "";
			String comments = "";
			List<String> parentList = new ArrayList<>();

			// extract data from the current constraint and update the
			// attributes

			// if EnglishConstraint
			if (curConstraint instanceof EnglishConstraint) {
				text = ((EnglishConstraint) curConstraint).getText();
				export = true;
			}

			EList<Data> dataList = curConstraint.getData();
			for (Data curData : dataList) {
				String newText = "";
				if (curData instanceof DescriptionData) {
					newText = ((DescriptionData) curData).getString();
					text = detectDuplicates(id, type, "text", text, newText);
				} else if (curData instanceof OwnerData) {
					newText = ((OwnerData) curData).getString();
					owner = detectDuplicates(id, type, "owner", owner, newText);
				} else if (curData instanceof ReviewData) {
					newText = ((ReviewData) curData).getString();
					reviewDate = detectDuplicates(id, type, "reviewDate", reviewDate, newText);
				} else if (curData instanceof SourceData) {
					newText = ((SourceData) curData).getString();
					source = detectDuplicates(id, type, "source", source, newText);
				} else if (curData instanceof RationaleData) {
					newText = ((RationaleData) curData).getString();
					rationale = detectDuplicates(id, type, "rationale", rationale, newText);
				} else if (curData instanceof CommentsData) {
					newText = ((CommentsData) curData).getString();
					comments = detectDuplicates(id, type, "comments", comments, newText);
				} else if (curData instanceof TraceData) {
					// if parentList is not empty, there is a duplicate
					if (!parentList.isEmpty()) {
						throw new Exception("Duplicate parents for " + type + " ID " + id);
					}
					parentList = ((TraceData) curData).getIds();
				}
			}

			// if FormalConstraint and empty text, no export
			if (curConstraint instanceof FormalConstraint) {
				if ("".equals(text)) {
					export = false;
				} else {
					export = true;
				}
			}

			if (export) {
				// create requirement instance
				Requirement curRequirement = new Requirement(id, text, type, owner, component, parentList, reviewDate,
						source, rationale, comments);
				// add to requirement id map
				reqIDMap.put(id, curRequirement);
			}
		}
	}

	public MakeExcel(Specification s, File f) throws Exception {
		String compName = s.getName();
		// get the assumptions
		Iterator<Constraint> asIterator = s.getAssumptions().iterator();
		exportRequirement(asIterator, "ASSUMPTION", compName);
		// get the requirements
		Iterator<Constraint> reqIterator = s.getRequirements().iterator();
		exportRequirement(reqIterator, "REQT", compName);
		// get the properties
		Iterator<Constraint> propIterator = s.getBehaviors().iterator();
		exportRequirement(propIterator, "PROP", compName);
		// get the IDs for all existing requirements listed
		List<String> reqIDList = new ArrayList<>(reqIDMap.keySet());

		// extract the child list for each requirement
		for (HashMap.Entry<String, Requirement> reqEntry : reqIDMap.entrySet()) {
			// for each requirement, go through its parentList
			Requirement req = reqEntry.getValue();
			// for each requirement
			// go through its parentList
			Boolean topLevelReq = true;
			for (String parentID : req.getParentList()) {
				// check if parentID exists in requirementList
				if (reqIDList.contains(parentID)) {
					topLevelReq = false;
					// if yes, add the requirement ID to the parentID
					// requirement's childList
					reqIDMap.get(parentID).addChild(req.getID());
				}
				// if not, throw an exception
				else {
					// project specific text for Derived and Originating
					// requirements
					// marked in the parents attribute
					if (!parentID.equals("HALWA_Derived") && !parentID.equals("HALWA_Originating")) {
						throw new Exception("parent ID " + parentID + " for req_ID " + req.getID() + " is not defined");
					}
				}
			}
			// add to topLevelList if the topLevelReq flag is true
			if (topLevelReq) {
				topLevelReqList.add(req.getID());
			}
		}
	}

	private String detectDuplicates(String id, String type, String attributeName, String text, String newText)
			throws Exception {
		if ("".equals(text)) {
			text = newText;
		} else {
			throw new Exception("Duplicate " + attributeName + " for " + type + " ID " + id);
		}
		return text;
	}

}
