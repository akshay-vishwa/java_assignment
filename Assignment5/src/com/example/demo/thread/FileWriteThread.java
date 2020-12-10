package com.example.demo.thread;

import java.io.File;


import com.example.demo.service.FileService;
public class FileWriteThread implements Runnable {
	File file=new File("MULTITASKING.txt");
	String[] array= {"AKSHAY","RAVI"};
	FileService service=new FileService();
	

	@Override
	public void run() {
		boolean result=service.writeObjectToFile(array,file);
		if(result) {
			System.out.println("One Object Serialized");
			this.notifyAll();
			
		}else {
			System.out.println("Checked-Exception");
		  

	}
	}
}
