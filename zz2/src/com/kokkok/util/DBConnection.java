package com.kokkok.util;

import java.sql.*;

public class DBConnection {
	
	
	private DBConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	
	private static class Holder {
		public static final DBConnection INSTANCE = new DBConnection();
	}
	
	public static DBConnection getInstance() {
		return Holder.INSTANCE;
	}
	
	
	public static Connection makeConnection() throws SQLException {	
	return DriverManager.getConnection("jdbc:oracle:thin:@localhost:orcl","ora_user3","han3");
	
	}
}
