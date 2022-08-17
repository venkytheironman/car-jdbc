package com.ty.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	String url = "jdbc:mysql://localhost:3306";
	String userName = "root";
	String password = "root";

	public void saveData(Product pro) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3
			Statement stm = con.createStatement();
			// 4
			String q = "INSERT INTO ty_learn.product VALUES(" + pro.id + ",'" + pro.name + "','" + pro.type + "',"
					+ pro.cost + ")";
			stm.execute(q);

			con.close();
			System.out.println("Data inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateData(Product pro) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3
			Statement stm = con.createStatement();
			// 4
			String q = "UPDATE ty_learn.product SET name='" + pro.name + "',type='" + pro.type + "',cost=" + pro.cost
					+ "WHERE id= " + pro.id;
			stm.execute(q);

			con.close();
			System.out.println("Data updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	Product findById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3
			Statement stm = con.createStatement();
			// 4
			String q = "SELECT * FROM ty_learn.product WHERE id=" + id;
			ResultSet rs = stm.executeQuery(q);

			while (rs.next()) {
				// id=rs.getInt(1);
// 				String name = rs.getString(2);
// 				String type = rs.getString(3);
// 				int cost = rs.getInt(4);
				Product p = new Product();
				p.id = rs.getInt(1);
				p.name = rs.getString(2);
				p.type = rs.getString(3);
				p.cost = rs.getInt(4);
				return p;
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Product> disp() {
		 ArrayList<Product> al = new ArrayList();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			// 3
			Statement stm = con.createStatement();
			// 4
			String q = "SELECT * FROM ty_learn.product";
			ResultSet rs = stm.executeQuery(q);

			while (rs.next()) {
				// id=rs.getInt(1);
// 				String name = rs.getString(2);
// 				String type = rs.getString(3);
// 				int cost = rs.getInt(4);
				Product p = new Product();
				p.id = rs.getInt(1);
				p.name = rs.getString(2);
				p.type = rs.getString(3);
				p.cost = rs.getInt(4);
				al.add(p);
//				System.out.println("Id is " + p.id);
//				System.out.println("name is " + p.name);
//				System.out.println("type is " + p.type);
//				System.out.println("Cost is " + p.cost);
//				System.out.println("------------------------");
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

//	public void displayDetails(Product p) {
//		System.out.println("Id is " + p.id);
//		System.out.println("name is " + p.name);
//		System.out.println("type is " + p.type);
//		System.out.println("Cost is " + p.cost);
//	}
}
