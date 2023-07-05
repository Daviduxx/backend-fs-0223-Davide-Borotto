package com.epicode.es3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {
	
	private static File file = new File("doc/test.txt");

	public static void main(String[] args) {
		try {
			registraPresenza("Mario Rossi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void registraPresenza(String testo) throws IOException {
		
		FileUtils.writeStringToFile(file, testo, "UTF-8", true);
	}

}
