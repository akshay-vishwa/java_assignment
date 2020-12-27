package com.assignment.jtest;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.assignment.utils.DbConnectionUtils;
import com.mysql.cj.jdbc.DatabaseMetaData;

class jtest {
	
	Connection connection;
	boolean checkDatabase;
	

	public jtest() {
		super();
		connection=DbConnectionUtils.getMySqlConnection();
		checkDatabase=true;
	}
	
	
	

	@Test
	@DisplayName("Checking if connection to the database contactbook works")
	void testDatabase() throws SQLException {
		System.out.println("Checking for Connections");
		assertNotNull(connection);
		if(connection!=null) {
			checkDatabase=true;
		}
	}
	
	@Test
	@DisplayName("Checking if table is present in database")
	void testTable() throws SQLException {
		
		assumeTrue(checkDatabase);
		System.out.println("check table executing....");
		DatabaseMetaData dbm =(DatabaseMetaData) connection.getMetaData();
		ResultSet table1=dbm.getTables(null, null, "contact", null);
		assertNotNull(table1);
		if(table1.next()) {
			System.out.println("contact table Present!");
			
		}
		ResultSet table2=dbm.getTables(null, null, "grouptable", null);
		assertNotNull(table2);
		if(table2.next()) {
			System.out.println("group table Present!");
		}
	}

}
