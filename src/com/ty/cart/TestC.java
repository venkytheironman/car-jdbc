package com.ty.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306";
		String userName="root";
		String password="root";
		
			try {
				//1
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2
				Connection con=DriverManager.getConnection(url,userName,password);
				//3
				Statement stm = con.createStatement();
				//
				String q = "SELECT * FROM ty_learn.user";
				ResultSet rs= stm.executeQuery(q);
				while(rs.next()) {
					int id=rs.getInt(1);
					String email = rs.getString(2);
					String name = rs.getString(3);
					String pass = rs.getString(4);
					int age = rs.getInt(5);
					System.out.println("Id is "+id);
					System.out.println("Email is "+email);
					System.out.println("name is "+name);
					System.out.println("password is "+pass);
					System.out.println("age is "+age);
					System.out.println(" ************ ");
					
				}
				
				
				
				//5
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
