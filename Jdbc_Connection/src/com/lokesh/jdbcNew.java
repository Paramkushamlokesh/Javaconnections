package com.lokesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcNew {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Anjali","root","root");
				System.out.println("connection sucessfull");
				String stmt="Create table stu(name varchar(20),roll int)";
				Statement ss=con.createStatement();
				
				boolean ans=ss.execute(stmt);
				
				if(!ans) {
					System.out.println("done table creation");
				}
				else {
					System.out.println("oops");
				}
				
				con.close();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}
		
	}

}
