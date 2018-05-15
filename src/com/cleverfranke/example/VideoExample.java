package com.cleverfranke.example;

import com.cleverfranke.util.FileSystem;

import processing.core.PApplet;
import processing.video.Movie;

public class VideoExample extends PApplet {

	private Movie movie;

	@Override
	public void settings() {
		size(1024, 768);
	}

	@Override
	public void setup() {
		String movieFile = FileSystem.getApplicationPath("data/examples/transit.mov");
		movie = new Movie(this, movieFile);
		movie.loop();
	}

	@Override
	public void draw() {
		background(0);
		image(movie, 0, 0, width, height);
	}

	public void movieEvent(Movie m) {
		m.read();
	}

	public static void main(String[] args) {
		// Program execution starts here
		FileSystem.setDefaultLibraryPaths();
		PApplet.main(VideoExample.class.getName());
	}

}
