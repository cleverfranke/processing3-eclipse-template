package com.cleverfranke.util;

import java.io.File;

public class FileSystem {
	
	/**
	 * Fetch absolute path to a file or directory relative to the application path. Does not check whether the 
	 * requested path exists 
	 * 
	 * @param path relative to the project directory or executable JAR (starting with file separator)
	 * @return absolute path to the requested subpath
	 */
	public static String getApplicationPath(String subPath) {
		
		String applicationPath = new File("").getAbsolutePath();
		
		if (subPath.isEmpty()) {
			return applicationPath;
		} else {
			return new File(applicationPath + File.separator + subPath).getAbsolutePath();
		}
		
	}
	
	/**
	 * Fetch root application path (e.g. path to the
	 * 
	 * @return
	 */
	public static String getApplicationPath() {
		return getApplicationPath("");
	}
	
}
