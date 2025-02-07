package com.mysql.jdbc.StudentProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentData {
	Scanner sc = new Scanner(System.in);
	Connection con = null;

	// addStudent()
	// findAllStudentsByCountry()
	// findAllStudentsByClgName()
	// findStudentBetweenAge()
	// UpdatestudentByStyphend()
	// deleteStudentById()
	// deleteStudentByStudentName() 

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdbs", "root", "root123");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public void addStudent() {
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO studentdata VALUES(?,?,?,?,?,?)");
			System.out.println("enter studentId");
			pstmt.setInt(1, sc.nextInt());

			System.out.println("enter studentName");
			pstmt.setString(2, sc.next());

			System.out.println("enter studentAge");
			pstmt.setInt(3, sc.nextInt());

			System.out.println("enter studentCountry");
			pstmt.setString(4, sc.next());

			System.out.println("enter studentclgName");
			pstmt.setString(5, sc.next());

			System.out.println("enter studentStyphend");
			pstmt.setInt(6, sc.nextInt());

			int rowaffected = pstmt.executeUpdate();
			if (rowaffected > 0) {
				System.out.println(rowaffected + " rows are inserted");
			} else {
				System.out.println("no rows are inseted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void findAllStudentsByCountry() {
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM studentdata WHERE studentCountry=?");

			System.out.println("enter studentCountry");
			pstmt.setString(1, sc.next());

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("studentName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void findAllStudentsByClgName() {
	Connection con=getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM studentdata WHERE studentclgName=?");

			System.out.println("enter studentclgName");
			pstmt.setString(1, sc.next());

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("studentName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void findStudentBetweenAge() {
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM studentdata WHERE studentAge BETWEEN ? and ?");
			System.out.println("enter the studentAge");
			pstmt.setInt(1, sc.nextInt());

			System.out.println("enter another studentAge");
			pstmt.setInt(2, sc.nextInt());

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("studentName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	

		public void UpdatestudentStyphendById() {
			Connection con = getConnection();
			try {
				PreparedStatement pstmt = con.prepareStatement("UPDATE studentdata SET studentStyphend=? WHERE studentId=?");
				System.out.println("enter value to update studentStyphend");
				pstmt.setInt(1, sc.nextInt());

				System.out.println("Enter the studentID");
				pstmt.setInt(2, sc.nextInt());

				int rowaffected = pstmt.executeUpdate();
				if (rowaffected >= 0) {
					System.out.println(rowaffected + "are update successufully");
				} else {
					System.out.println("no row affected");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void deleteStudentById() {
			Connection conn = getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM studentdata WHERE studentId=?");
				System.out.println("enter studentid");
				pstmt.setString(1, sc.next());

				int rowaffected = pstmt.executeUpdate();
				if (rowaffected >= 0) {
					System.out.println(rowaffected + "are deleted successufully");
				} else {
					System.out.println("no row  are delete ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

		public void deleteStudentByStudentName() {
			Connection conn = getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM studentdata WHERE studentName=?");
				System.out.println("enter studentName");
				pstmt.setString(1, sc.next());

				int rowaffected = pstmt.executeUpdate();
				if (rowaffected >= 0) {
					System.out.println(rowaffected + "are deleted successufully");
				} else {
					System.out.println("no row  are delete ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}


