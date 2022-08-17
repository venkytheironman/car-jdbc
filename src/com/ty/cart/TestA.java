package com.ty.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestA {

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
				//4
//				String q="INSERT INTO ty_learn.user VALUES(5,'vishal@gmail.com','Vishal','Hello','33')";
//				stm.execute(q);
				
				String h="DELETE FROM ty_learn.user WHERE id=5";
				stm.execute(h);
				
				//5
				con.close();
				System.out.println("Data deleted");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

	}

}
