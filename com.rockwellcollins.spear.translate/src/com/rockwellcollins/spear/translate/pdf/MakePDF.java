package com.rockwellcollins.spear.translate.pdf;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.Variable;
import com.rockwellcollins.spear.util.SpearSwitch;

/*
 * This class uses iText to generate PDFs. IText is free, but 
 */
public class MakePDF extends SpearSwitch<Integer> {

	public static void toPDF(Specification s, File f) {
		new MakePDF(s,f);
	}
	
	//this is to keep from falling through to the default case on a null value.
	public static final Integer DONE = 0;

	private Document document;
	private FontFamily fontFamily;
	private BaseColor baseColor;
	
	private void addToDocument(Element e) {
		try {
			this.document.add(e);
		} catch (DocumentException d) {
			System.out.println("Error adding " + e + " to document.");
			d.printStackTrace();
		}
	}
	
	public MakePDF(Specification s, File f) {
		this.document = new Document();
		this.fontFamily=FontFamily.HELVETICA;
		this.baseColor = BaseColor.BLACK;
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(f));
			document.open();
			this.doSwitch(s);
			
			/* this line is required to satisfy the license 
			 * agreement for iText's AGPL license */
			document.addProducer();
			
			document.close();
		} catch (Exception e) {
			System.out.println("Error opening/closing document.");
			e.printStackTrace();
		}
	}
	
	@Override
	public Integer caseSpecification(Specification s) {
		Paragraph specP = new Paragraph("Specification:" + s.getName(), new Font(fontFamily, 18, Font.BOLD, baseColor));
		specP.setAlignment(Paragraph.ALIGN_CENTER);
		this.addToDocument(specP);
		
		Paragraph inputsP = new Paragraph("Inputs:", new Font(fontFamily, 18, Font.BOLD, baseColor));
		inputsP.setAlignment(Paragraph.ALIGN_LEFT);
		this.addToDocument(inputsP);
		
		List list = new List(true,20);
		Font f = new Font(fontFamily, 12, Font.NORMAL, baseColor);
		for(Variable v : s.getInputs()) {
			list.add(new ListItem(v.getName(), f));
		}
		this.addToDocument(list);
		
		return DONE;
	}
}
