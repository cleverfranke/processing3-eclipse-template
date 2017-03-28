package com.cleverfranke.example.print;

import com.cleverfranke.util.FileSystem;
import com.cleverfranke.util.print.Pdf;

import processing.core.PApplet;

public class TextExample extends PApplet {
	
	public void setup() { 
		
		// Determine where to write the PDF file
		String pdfPath = FileSystem.getApplicationPath("output/text.pdf");
		System.out.println("Printing to " + pdfPath);

		// Create PDF object (300x100 points)
		Pdf pdf = new Pdf(this, 300, 100, pdfPath);
		pdf.beginDraw();
		
		// The font "andalemo.ttf" must be located in the 
		// current sketch's "data" directory to load successfully
		pdf.textFont(createFont("andalemo.ttf", 32));
		pdf.textSize(32);
		
		// Finalize pdf
		pdf.dispose();
		
		// End application
		System.out.println("Pdf writing done");
		exit();
		
	}
	
	public static void main(String[] args) {
		PApplet.main(TextExample.class.getName());
	}

}
