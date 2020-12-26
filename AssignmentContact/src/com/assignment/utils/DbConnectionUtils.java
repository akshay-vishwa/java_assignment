package com.assignment.utils;

import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;


public class DbConnectionUtils {

	
	
	public static Connection getMySqlConnection() {
		
		Connection connect=null;
		
		String fileName="DbConnection.properties";
		try {
			
			InputStream inStream=DbConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
		    Properties props =new Properties();
		    props.load(inStream);
		    
		    connect=DriverManager.getConnection(props.getProperty("datasource.url"),
		    		                        props.getProperty("datasource.username"),
		    		                        props.getProperty("datasource.password")
		    		                        );
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connect;
		
	}
	
}
