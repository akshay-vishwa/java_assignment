package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) {
	
		ExecutorService executor=Executors.newSingleThreadExecutor();
		FileReaderThread write=new FileReaderThread();
		FileWriteThread read=new FileWriteThread();
		
		executor.submit(read);
		executor.submit(write);
		

		executor.shutdown();
	}

}
