package com.rockwellcollins.spear.translate.excel;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jkind.JKindException;
import jkind.excel.ExcelUtil;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelFormatter implements Closeable {

	private WritableWorkbook workbook;

	private WritableSheet sheet;
	private int row;
	private final int numOfCols = 11;

	/*
	 * CellFormats cannot be static, since JXL has strange results when a cell
	 * format is reused in another workbook. See {@link
	 * http://jexcelapi.sourceforge.net/resources/faq/}.
	 */
	private final CellFormat boldFormat = ExcelUtil.getBoldFormat();
	private final CellFormat defaultFormat = new WritableCellFormat();

	public ExcelFormatter(File file) {
		try {
			workbook = Workbook.createWorkbook(file);
		} catch (IOException e) {
			throw new JKindException("Error writing to Excel file", e);
		}
	}

	@Override
	public void close() {
		try {
			if (workbook != null) {
				workbook.write();
				workbook.close();
				workbook = null;
			}
		} catch (Exception e) {
			throw new JKindException("Error closing Excel file", e);
		}
	}


	public WritableSheet writeSpecification(List<String> topLevelReqList, HashMap<String, Requirement> reqIDMap) {
		try {
			sheet = workbook
					.createSheet("Requirements", workbook.getNumberOfSheets());
			row = 0;
			ExcelUtil.autosize(sheet, 1);			
			writeColHeader();
			writeRequirement(topLevelReqList, reqIDMap);
			return sheet;
		} catch (WriteException e) {
			throw new JKindException("Error writing counterexample to Excel file", e);
		}
	}
	
	private void writeColHeader() throws WriteException, RowsExceededException {
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("Requirement/Property/Assumption Text");
        headers.add("REQT/PROP/AS");
        headers.add("Owner");
        headers.add("Component");
        headers.add("Parents");
        headers.add("Children");
        headers.add("Review Date");
        headers.add("Source");
        headers.add("Rationale");   
        headers.add("Comments");  
        int col = 0;
		for (String headerStr : headers) {
			sheet.addCell(new Label(col, row, headerStr, boldFormat));
			col++;
		}
		row++;
	}
	
	private void writeRequirement(List<String> reqList, HashMap<String, Requirement> reqIDMap) throws WriteException, RowsExceededException {
		//go through the current requirement list
    	for(String reqID: reqList){
    		//print the current requirement
			Requirement req = reqIDMap.get(reqID);
        	List<String> attributeList = req.exportStrs();
    		for (int col = 0; col < numOfCols; col++) {
				sheet.addCell(new Label(col, row, attributeList.get(col), defaultFormat));
    		}
    		row++;
    		//print requirements from the child list of the current requirement
     		writeRequirement(req.getChildList(), reqIDMap);
    	}
	}
}

