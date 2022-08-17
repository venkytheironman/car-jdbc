package com.ty.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductCRUD {
	static int id;
	static String name;
	static String type;
	static int cost;
	
	public static void saveProduct(int id,String name,String type,int cost) {
		String url="jdbc:mysql://localhost:3306";
		String userName="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			//3
			Statement stm = con.createStatement();
			//4
			String q="INSERT INTO ty_learn.product VALUES("+id+",'"+name+"','"+type+"',"+cost+")";
			stm.execute(q);
			
		
			con.close();
			System.out.println("Data inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2
       catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void deleteProduct(int id) {
		String url="jdbc:mysql://localhost:3306";
		String userName="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			//3
			Statement stm = con.createStatement();
			//4
			String h="DELETE FROM ty_learn.product WHERE id="+id;
			stm.execute(h);
			
		
			con.close();
			System.out.println("Data deleted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2
       catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printAllProducts() {
		
		String url="jdbc:mysql://localhost:3306";
		String userName="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			//3
			Statement stm = con.createStatement();
			//4
			String q="SELECT * FROM ty_learn.product";
			ResultSet rs= stm.executeQuery(q);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int cost = rs.getInt(4);
				System.out.println("Id is "+id);
				System.out.println("name is "+name);
				System.out.println("type is "+type);
				System.out.println("cost is "+cost);
				System.out.println("---------------------");
				
			}
			
		
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2
       catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//saveProduct(1,"TV","Electronics",1234);
		//saveProduct(5,"Table","Household",2000);
		//deleteProduct(5);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: ");
		id=sc.nextInt();
		System.out.println("Enter name: ");
	    name=sc.next();
	    System.out.println("Enter type: ");
		type=sc.next();
		System.out.println("Enter cost: ");
		cost=sc.nextInt();
		saveProduct(id,name,type,cost);
		printAllProducts();

	}

}
