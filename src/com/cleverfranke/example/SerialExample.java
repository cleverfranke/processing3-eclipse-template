package com.cleverfranke.example;

import com.cleverfranke.util.FileSystem;

import processing.core.PApplet;
import processing.serial.Serial;

public class SerialExample extends PApplet {
	
	private Serial myPort;
	private String receivedData = "";
	
	@Override
	public void settings() {
		size(640, 480);
		FileSystem.setDefaultLibraryPaths();
	}
	
	@Override
	public void setup() {

		// Fetch port name (connect to last listed port)
		String[] ports = Serial.list();
		String portName = ports.length > 0 ? ports[ports.length - 1] : null;
		
		// Open port
		if (portName != null) {
			System.out.println("Opening port " + portName);
			myPort = new Serial(this, portName, 9600);
		} else {
			System.out.println("Can't find any serial ports");
		}
		
	}
	
	@Override
	public void draw() {
		background(0);
		text("This sketch will display the last received data from the serial port, and send all keystrokes", 40, 40);
		text(receivedData, 40, 60, width - 80, height - 100);
	}
	
	public void serialEvent(Serial myPort) {
		
		String incomingString = myPort.readString();
		
		// Print all incoming data
		System.out.println("Read: " + incomingString);
		
		// Add to display string
		receivedData += incomingString;
		
	}
	
	@Override
	public void keyReleased() {
		// Send key strokes to serial port
		if (myPort != null) {
			System.out.println("Sent: " + key);
			myPort.write(key);
		}
	}

	public static void main(String[] args) {
		// Program execution starts here
		PApplet.main(SerialExample.class.getName());
	}

}
