package com.cleverfranke.example;

import com.cleverfranke.util.FileSystem;

import processing.core.PApplet;

public class BasicExample extends PApplet {
	
	private float a;
	
	@Override
	public void settings() {
		// Add settings here
		size(1024, 768);
		FileSystem.setDefaultLibraryPaths();
	}
	
	@Override
	public void setup() {
		// Add setup code here
	}
	
	@Override
	public void draw() {
		
		// Draw bg
		background(0);
		
		// Calculate position of ellipse, based on angle
		float x = width / 2 + cos(a) * 300;
		float y = height / 2 + sin(a) * 300;
		
		// Draw ellipse
		fill(0, 255, 255);
		ellipse(x, y, 30, 30);
		
		// Update angle
		a += 0.05f;
		
	}

	public static void main(String[] args) {
		// Program execution starts here
		PApplet.main(BasicExample.class.getName());
	}
	
}
