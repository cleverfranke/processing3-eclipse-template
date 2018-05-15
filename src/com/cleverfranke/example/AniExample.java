package com.cleverfranke.example;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniSequence;
import de.looksgood.ani.easing.Easing;
import processing.core.PApplet;

/**
 * Example for using the ANI animation/transition
 * library.
 * 
 * More examples are available on the ANI website: 
 * http://www.looksgood.de/libraries/Ani/
 */
public class AniExample extends PApplet {
	
	private AniSequence sequence;
	
	private float x, y; 
	private float diameter = 5;
	
	@Override
	public void settings() {
		// Add settings here
		size(640, 480);
	}
	
	@Override
	public void setup() {
		// you have to call always Ani.init() first!
		Ani.init(this);
		
		// Create transition sequence
		sequence = new AniSequence(this);
		sequence.beginSequence();
		sequence.add(Ani.to(this, 2, "x:0,y:-100", Easing.CIRC_IN));
		sequence.add(Ani.to(this, 1, "diameter", 55, Easing.ELASTIC_IN));
		sequence.add(Ani.to(this, 2, "x:250,y:180", Easing.BOUNCE_OUT));
		sequence.add(Ani.to(this, 2, "x:-200,y:-150", Easing.BOUNCE_OUT));
		sequence.add(Ani.to(this, 1, "x:0,y:0,diameter:5", Easing.BOUNCE_OUT, "onEnd:onSequenceEnd"));
		sequence.endSequence();

		// Start the whole sequence
		sequence.start();
	}
	
	@Override
	public void draw() {
		  background(255);
		  
		  // Translate to center
		  translate(width / 2, height / 2); 
		  
		  // Ellipse
		  fill(0);
		  ellipse(x, y, diameter, diameter);
	}
	
	@SuppressWarnings("unused")
	private void onSequenceEnd() {
		// Restart sequence
		sequence.start();
	}

	public static void main(String[] args) {
		// Program execution starts here
		PApplet.main(AniExample.class.getName());
	}
	
}
