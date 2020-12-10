package com.example.demo.thread;

import java.io.File;

import com.example.demo.service.FileService;

public class FileReaderThread implements Runnable {

	File file=new File("MULTITASKING.txt");
	String[] array= {"AKSHAY","RAVI"};
	FileService service=new FileService();

	@Override
	public void run() {
		String[] read=(String[])service.readObjectFromFile(file);
		if(read!=null) {
			System.out.println(read[1].toString());
			
		}else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


}

