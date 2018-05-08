import com.cleverfranke.util.FileSystem;

import processing.core.PApplet;

public class Main extends PApplet {
	
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
		// Add draw code here
	}

	public static void main(String[] args) {
		// Program execution starts here
		PApplet.main(Main.class.getName());
	}

}
