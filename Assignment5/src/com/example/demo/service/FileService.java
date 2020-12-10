package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileService {
	
public boolean writeObjectToFile(String[] array,File file) {
		
		boolean result =false;
		
		try (ObjectOutputStream outStream =new ObjectOutputStream(new FileOutputStream(file))){
			
			outStream.writeObject(array);
				result=true;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public Object[] readObjectFromFile(File file) {
		
		Object[] obj=null;
		
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))){
			obj=(Object[]) inStream.readObject();
			
		}catch(ClassNotFoundException | IOException e){
			
			e.printStackTrace();
			
		}
		
		return obj;
	}

}
