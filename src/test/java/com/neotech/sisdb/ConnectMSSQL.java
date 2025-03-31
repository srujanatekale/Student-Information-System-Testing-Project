package com.neotech.sisdb;

import java.sql.*;

public class ConnectMSSQL {

	public static String dbUserName = "SisLogin";
	public static String dbPassword = "Neotech#2022";

	public static String dbUrl = "jdbc:sqlserver://108.179.5.150:1433; databaseName=Test;";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM STUDENT WHERE FirstName = 'Michael'");

		while (rs.next()) {
			String fName = rs.getObject("FirstName").toString();
			String lName = rs.getString("LastName");
			String user = rs.getObject(5).toString();
			String pass = rs.getString(6);

			System.out.println(fName + " " + lName + " - " + user + " " + pass);
		}

		rs.close();
		st.close();
		conn.close();

	}

}
