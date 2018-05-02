package com.cleverfranke.example;

import processing.core.PApplet;
import processing.serial.Serial;

public class SerialExample extends PApplet {
	
	private Serial myPort;
	
	@Override
	public void settings() {
		size(1024, 768);
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
	public void draw() {}
	
	public void serialEvent(Serial myPort) {
		// Print all incoming data
		System.out.println("Read: " + myPort.readString());
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
