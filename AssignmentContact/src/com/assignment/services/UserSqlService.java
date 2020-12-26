package com.assignment.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.assignment.ifaces.UserAccess;
import com.assignment.model.ContactDetails;
import com.assignment.utils.DbConnectionUtils;

public class UserSqlService implements UserAccess<ContactDetails> {

    private Connection connect;
    List<ContactDetails> list;
    FileService csvWrite;
    Scanner sc;
    
	

	public UserSqlService() {
		super();
		this.connect = DbConnectionUtils.getMySqlConnection();
		this.list=findAll();
		this.sc=new Scanner(System.in);
	}
	
    public List<ContactDetails> findAll() {
		
    	String sql="select * from contact;";
		List<ContactDetails> contactList=new ArrayList<>();
		
		try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String address=rs.getString("address");
				Long number=rs.getLong("number");
				String imgref=rs.getString("imgref");
				LocalDate dob = rs.getDate("dateofbirth").toLocalDate();
				String mailid=rs.getString("mailid");
				String groupid=rs.getString("groupid");
				ContactDetails contact=new ContactDetails(name,address,number,imgref,dob,mailid,groupid);
				contactList.add(contact);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contactList;
	}
	
	@Override
	public void birthday(int month) {
		boolean entry=true;
		for(ContactDetails contact:list) {
			if(contact.getDateOfBirth().getMonthValue()==month) {
				System.out.println(contact);
				entry=false;
				}
		}
		
		if(entry)
			System.out.println("No data found");
		else {
			System.out.println("Do you want to save the file:(n/y)");
			String save=sc.next();
			if(save.equals("y")) {
				
				String data="";
				System.out.println("Enter file name:");
				String name=sc.next();
				name="data/"+name+".csv";
				csvWrite=new FileService(name);
				
				for(ContactDetails contact:list) {
					if(contact.getDateOfBirth().getMonthValue()==month) {
						data+=contact.toStringSave();
						}
				}
				csvWrite.addData(data);
			}
		}
	}

	@Override
	public void groupContact(String group) {
		boolean entry=true;
		for(ContactDetails contact:list) {
			if(contact.getGroupId().equals(group)) {
				System.out.println(contact);
				entry=false;
				}
		}
		
		if(entry)
			System.out.println("No data found");
		else {
			System.out.println("Do you want to save the file:(n/y)");
			String save=sc.next();
			if(save.equals("y")) {
				
				String data="";
				System.out.println("Enter file name:");
				String name=sc.next();
				name="data/"+name+".csv";
				csvWrite=new FileService(name);
				
				for(ContactDetails contact:list) {
					if(contact.getGroupId().equals(group)) {
						data+=contact.toStringSave();
						}
				}
				csvWrite.addData(data);
			}
		}
	}

	@Override
	public void nameNumber() {
		for(ContactDetails contact:list) {
			System.out.println(contact.getName()+"  :  "+contact.getNumber());
		}
		System.out.println("Do you want to save the file:(n/y)");
		String save=sc.next();
		if(save.equals("y")) {
			
			String data="";
			System.out.println("Enter file name:");
			String name=sc.next();
			name="data/"+name+".csv";
			csvWrite=new FileService(name);
			
			for(ContactDetails contact:list) {
				data+=contact.getName()+"  ,  "+contact.getNumber()+"\n";
			}
			csvWrite.addData(data);
		}
	}

	@Override
	public void displayAll() {
		for(ContactDetails contact:list) {
			System.out.println(contact);
		}	
		System.out.println("Do you want to save the file:(n/y)");
		String save=sc.next();
		if(save.equals("y")) {
			
			String data="";
			System.out.println("Enter file name:");
			String name=sc.next();
			name="data/"+name+".csv";
			csvWrite=new FileService(name);
			
			for(ContactDetails contact:list) {
					
				data+=contact.toStringSave();		
			}
			csvWrite.addData(data);
		}	
	}

	@Override
	public void nameMail() {
		for(ContactDetails contact:list) {
			System.out.println(contact.getName()+"  :  "+contact.getMailId());
		}
		System.out.println("Do you want to save the file:(n/y)");
		String save=sc.next();
		if(save.equals("y")) {
			
			String data="";
			System.out.println("Enter file name:");
			String name=sc.next();
			name="data/"+name+".csv";
			csvWrite=new FileService(name);
			
			for(ContactDetails contact:list) {
				data+=contact.getName()+"  ,  "+contact.getMailId()+"\n";
			}
			csvWrite.addData(data);
		}
		
	}

	@Override
	public void ascending() {

		String sql="select count(name), groupid"
				+ "  from contact"
				+ " group by groupid order by count(name);";
		
		try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int count=rs.getInt("count(name)");
				String group=rs.getString("groupid");
				if(group.equals("A")) {
					System.out.println("Relatives:"+count);
					sql("A");
					}
				else if(group.equals("B")) {
					System.out.println("Personal Friends:"+count);
					sql("B");
					}
				else {
					System.out.println("Prefessional friends:"+count);
					sql("C");
					}
			
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void sql(String group) {
		String sql="select * from contact where groupid=?;";
		
		try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
			pstmt.setString(1, group);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String address=rs.getString("address");
				Long number=rs.getLong("number");
				String imgref=rs.getString("imgref");
				LocalDate dob = rs.getDate("dateofbirth").toLocalDate();
				String mailid=rs.getString("mailid");
				String groupid=rs.getString("groupid");
				ContactDetails contact=new ContactDetails(name,address,number,imgref,dob,mailid,groupid);
				System.out.println(contact);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
