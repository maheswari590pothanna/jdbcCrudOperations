package com.mysql.jdbc.StudentProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdbs", "root", "root123");
			Statement statement = con.createStatement();
			String query = ("INSERT INTO student VALUES (studentId=4,studentName='mahi',studentEmail='mahi@gmail.com',studentAddress='atp')");
			int rowaffected = statement.executeUpdate(query);
			if (rowaffected > 0) {
				System.out.println(rowaffected + " row is inserted successfully");
			} else {
				System.out.println("no rows are inserted");
			}
			con.close();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
