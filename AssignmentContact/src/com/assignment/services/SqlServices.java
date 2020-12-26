package com.assignment.services;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.assignment.ifaces.SqlAccess;
import com.assignment.model.ContactDetails;
import com.assignment.utils.DbConnectionUtils;

public class SqlServices implements SqlAccess<ContactDetails>{
	
	private Connection connect;
	

	public SqlServices() {
		super();
		this.connect = DbConnectionUtils.getMySqlConnection();
	}

	@Override
	public int addContact(ContactDetails t) {

		String sql="insert into contact values(?,?,?,?,?,?,?);";
		int row=0;
		
        try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
        	pstmt.setString(1, t.getName());
        	pstmt.setString(2, t.getAddress());
        	pstmt.setLong(3, t.getNumber());
        	pstmt.setString(4, t.getImgRef());
        	pstmt.setDate(5, Date.valueOf(t.getDateOfBirth()));
        	pstmt.setString(6, t.getMailId());
        	pstmt.setString(7, t.getGroup());
        	
        	
			row =pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}

	@Override
	public List<ContactDetails> findAll() {
		
		String sql="select contact.name,contact.address,contact.number,contact.imgref,contact.dateofbirth,contact.mailid,grouptable.groupname from "
				+ "contact inner join grouptable on contact.groupid=grouptable.groupid;";
		List<ContactDetails> contactList=new ArrayList<>();
		
		try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
			ResultSet rs=pstmt.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				String name=rs.getString("name");
				String address=rs.getString("address");
				Long number=rs.getLong("number");
				String imgref=rs.getString("imgref");
				LocalDate dob = rs.getDate("dateofbirth").toLocalDate();
				String mailid=rs.getString("mailid");
				String groupid=rs.getString("grouptable.groupname");
				ContactDetails contact=new ContactDetails(name,address,number,imgref,dob,mailid,groupid);
				contactList.add(contact);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contactList;
	}

	@Override
	public int update( ContactDetails update,long PhNumber) {
		

		int row=0;
	    	String sql="update contact set name=?,address=?,number=?,imgref=?,dateofbirth=?,mailid=?,groupid=? where number=?;";
	    	try(PreparedStatement pstmt=connect.prepareStatement(sql)){
				
	        	pstmt.setString(1, update.getName());
	        	pstmt.setString(2, update.getAddress());
	        	pstmt.setLong(3, update.getNumber());
	        	pstmt.setString(4, update.getImgRef());
	        	pstmt.setDate(5, Date.valueOf(update.getDateOfBirth()));
	        	pstmt.setString(6, update.getMailId());
	        	pstmt.setString(7, update.getGroup());
	        	pstmt.setLong(8, PhNumber);
	        	
	        	
				row =pstmt.executeUpdate();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return row;
	}
	
	
    public boolean check(long number) {
    	boolean present=false;
		List<ContactDetails> list=new ArrayList<>();
		SqlServices sqlService =new SqlServices();
	    list=sqlService.findAll();
	    for(ContactDetails contact:list) {
	    	if(contact.getNumber()==number)
	    		present=true;
	    }
	    return present;
	}

	@Override
	public int remove(long number) {
		String sql="delete from contact where number=?;";
		
		int row=0;
    	
    	try(PreparedStatement pstmt=connect.prepareStatement(sql)){
        	
    		pstmt.setLong(1, number);
			row =pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	return row;

	}

	@Override
	public ContactDetails findByNumber(long number) {
		ContactDetails contact=null;
		SqlServices sqlService =new SqlServices();
		if( sqlService.check(number)) {
			List<ContactDetails> list=new ArrayList<>();
		    list=sqlService.findAll();
		    for(ContactDetails contact1:list) {
		    	if(contact1.getNumber()==number)
		    		contact=contact1;
		    }
		}else
			contact=null;
		return contact;
	}
	

	

}
