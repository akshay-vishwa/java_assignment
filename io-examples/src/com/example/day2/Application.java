package com.example.day2;
import java.io.*;

import com.example.day2.service.ProfessorService;

public class Application {

	public static void main(String[] args) {


		ProfessorService service =new ProfessorService();
		File file=new File("professor.sct");
		Professor[] prof= {new Professor(3838,"Suresh","ECE","phd"),
				           new Professor(388,"Ssh","ECE","phd")};
		int k=4;
		
		if(k==1) {
		boolean result=service.writeObjectToFile(prof,file);
		if(result) {
			System.out.println("One Object Serialized");
			
		}else {
			System.out.println("Checked-Exception");
		  }
		}
		
		if(k==2) {
			Professor[] prof1=(Professor[])service.readObjectFromFile(file);
			if(prof1!=null) {
				System.out.println(prof1[1].toString());
				
			}else {
				System.out.println("Checked-Exception");
			}
		}
		
		File fileTxt=new File("professor.txt");
		if(k==3) {
			
			Professor manish=new Professor(3838,"Suresh","ECE","phd");
			System.out.println("added:="+service.writeToTextfil(manish,fileTxt));
			System.out.println("added:="+service.writeToTextfil(manish,fileTxt));
		}

		if(k==4) {
			Professor[] list =service.readFromTextFIle(fileTxt);
			for(Professor each:list) {
				System.out.println(each);
			}
		}
	}

}
