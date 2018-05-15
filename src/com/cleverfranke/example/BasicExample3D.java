package com.cleverfranke.example;

import com.cleverfranke.util.FileSystem;

import processing.core.PApplet;

public class BasicExample3D extends PApplet {
	
	@Override
	public void settings() {
		// Add settings here
		size(640, 480, P3D);
	}
	
	@Override
	public void setup() {
		// Add setup code here
		noStroke();
	}
	
	@Override
	public void draw() {

		lights();
		background(0);
		float cameraY = height / 2.0f;
		float fov = mouseX / (float) width * PI / 2f;
		float cameraZ = cameraY / (float) Math.tan(fov / 2.0);
		float aspect = (float) width / (float) height;
		if (mousePressed) {
			aspect = aspect / 2.0f;
		}
		perspective(fov, aspect, cameraZ / 10.0f, cameraZ * 10.0f);

		translate(width / 2 + 30, height / 2, 0);
		rotateX(-PI / 6);
		rotateY(PI / 3 + mouseY / (float) height * PI);
		box(45);
		translate(0, 0, -50);
		box(30);
		
	}

	public static void main(String[] args) {
		// Program execution starts here
		FileSystem.setDefaultLibraryPaths();
		PApplet.main(BasicExample3D.class.getName());
	}
	
}
