package com.example.day2.service;

import java.io.*;
import com.example.day2.Professor;

public class ProfessorService {

	public boolean writeObjectToFile(Professor[] prof,File file) {
		
		boolean result =false;
		
		try (ObjectOutputStream outStream =new ObjectOutputStream(new FileOutputStream(file))){
			
			outStream.writeObject(prof);
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
	
	public boolean writeToTextfil(Professor prof,File file) {
		
		boolean result = false;
		
		try(PrintWriter writer=new PrintWriter(new FileWriter(file,true))){
			
			writer.println(prof);
			result=true;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
		public Professor[] readFromTextFIle(File file) {
			Professor[] list=new Professor[10];
			
			String line=null;
			
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				
				int i=0;
				while((line=reader.readLine())!=null) {
					String[] values=line.split(",");
					Professor prof =new Professor(Integer.parseInt(values[0]),values[1],values[2],values[3]);
					
					list[i]=prof;
					i++;
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		    return list;
	}
}
