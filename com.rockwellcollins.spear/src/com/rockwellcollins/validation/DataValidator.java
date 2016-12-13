package com.rockwellcollins.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.spear.ReviewData;
import com.rockwellcollins.spear.SpearPackage;

public class DataValidator extends AbstractSpearJavaValidator {

	@Check
	public void checkDates(ReviewData date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd");
		sdf1.setLenient(false);
		sdf2.setLenient(false);
		sdf3.setLenient(false);
		sdf4.setLenient(false);
		
		boolean success = false;
		
		if(!success) {
			try {
				Date d1 = sdf1.parse(date.getString());
				success = (d1 != null);
			} catch (Exception e) {
				success = false;
			}
		}
		
		if (!success) {
			try {
				Date d2 = sdf2.parse(date.getString());
				success = (d2 != null);
			} catch (Exception e) {
				success = false;
			}
		} 
		
		if (!success) {
			try {
				Date d3 = sdf3.parse(date.getString());
				success = (d3 != null);
			} catch (Exception e) {
				success = false;
			}
		} 
		
		if (!success) {
			try {
				Date d4 = sdf4.parse(date.getString());
				success = (d4 != null);
			} catch (Exception e) {
				success = false;
			}
		}
		
		if(!success) {
			error("Date is an illegal format. Supported formats are: mm-dd-yyyy, mm/dd/yyyy, yyyy-mm-dd, yyyy/mm/dd", date, SpearPackage.Literals.REVIEW_DATA__STRING);
		}
	}
}
