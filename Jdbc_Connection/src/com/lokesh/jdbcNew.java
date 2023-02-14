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
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from student");
				while(rs.next()) {
					System.out.println(rs.getString("name")+" "+rs.getInt("rollno")+" "+rs.getInt("marks"));
				}
			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}
		
	}

}
