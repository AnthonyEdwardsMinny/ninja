package com.ninzahrm.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class dbUtility {
	Connection con;

	
	
	public void getDbconnection() throws SQLException {
		try {
	      Driver driver=new Driver();
	      DriverManager.registerDriver(driver);
	      con=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	
	        }
		catch(Exception e) {
		
	}		
		
	}
		public void closeDbconnection() throws SQLException
		{
			con.close();
		}
		
		public ResultSet excecuteConSelectQuery(String query) throws Throwable {
			ResultSet result=null;
			try {
			Statement stat =con.createStatement();
			
			 result=stat.executeQuery(query);
			}catch(Exception e) {
				
			}
			return result;
			
		}
		public int executeNonSelectQuery(String query) {
			int result=0;
			try {
			Statement stat =con.createStatement();
			 result=stat.executeUpdate(query);
			
		}
			catch(Exception e) {
				
			}
	return	result;
}
	}
