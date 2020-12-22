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
import com.training.model.BloodDonor;
import com.trainingutils.DbConnectionUtil;

public class DonorService implements SqlAccess<BloodDonor>{

     private Connection connect;
	

	public DonorService() {
		super();
		this.connect = DbConnectionUtil.getMySqlConnection();
	}
	
	@Override
	public int addDonor(BloodDonor t) {
		String sql="insert into donor values(?,?,?,?,?,?,?);";
		int row=0;
		
        try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
        	pstmt.setString(1, t.getName());
        	pstmt.setInt(2, t.getAge());
        	pstmt.setString(3, t.getGender());
        	pstmt.setString(4, t.getBloodGroup());
        	pstmt.setInt(5, t.getPhoneNumber());
        	pstmt.setString(6, t.getEmail());
        	pstmt.setDate(7, Date.valueOf(t.getDateOfBirth()));
        	
        	
			row =pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}
	

	@Override
	public List<BloodDonor> findAll() {
		String sql="select * from donor;";
		List<BloodDonor> donor=new ArrayList<>();
		
		try(PreparedStatement pstmt=connect.prepareStatement(sql)){
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String gender=rs.getString("gender");
				String bloodgroup=rs.getString("bloodgroup");
				int phonenumber=rs.getInt("phonenumber");
				String email=rs.getString("email");
				LocalDate dob = rs.getDate("dateofbirth").toLocalDate();
				BloodDonor blood=new BloodDonor(name,age,gender,bloodgroup,phonenumber,email,dob);
				donor.add(blood);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return donor;
	}

}
