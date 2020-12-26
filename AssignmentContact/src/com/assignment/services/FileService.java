package com.assignment.services;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	FileWriter csvWrite;

	public FileService(String fileName) {
		super();
		try {
			this.csvWrite = new FileWriter(fileName);
		} catch (IOException e) {
			System.out.println("Couldnt create file");
			e.printStackTrace();
		}
	}
	
	public void addData(String data) {
		try {
			csvWrite.append(data);
			csvWrite.flush();
			csvWrite.close();
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println("Couldnt add date to file");
			e.printStackTrace();
		}
		
		
	}
}
