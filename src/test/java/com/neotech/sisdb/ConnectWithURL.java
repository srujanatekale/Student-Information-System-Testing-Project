package com.neotech.sisdb;

import java.sql.*;

public class ConnectWithURL {

	public static String dbUrl = "jdbc:sqlserver://108.179.5.150:1433; "
			+ " databaseName=Test; user=SisLogin; password=Neotech#2022; ";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl);

		// Information about Database
		DatabaseMetaData dbMeta = conn.getMetaData();

		String dbName = dbMeta.getDatabaseProductName();
		String dbVersion = dbMeta.getDatabaseProductVersion();

		System.out.println(dbName + " -> " + dbVersion);

		System.out.println("--------------------------------");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM STAFF WHERE LastName LIKE 'Mc%'");

		// Information about ResultSet
		ResultSetMetaData rsMeta = rs.getMetaData();

		// How many columns there are?
		int colCount = rsMeta.getColumnCount();
		System.out.println("colCount -> " + colCount);

		// What is the NAME of the 5th column?
		String colName5 = rsMeta.getColumnName(5);
		System.out.println("colName5 -> " + colName5);

		// What is the TYPE of the 5th column?
		String colType5 = rsMeta.getColumnTypeName(5);
		System.out.println("colType5 -> " + colType5);

		System.out.println("--------------------------------");

		for (int i = 1; i <= colCount; i++) {
			String colName = rsMeta.getColumnName(i);
			String colType = rsMeta.getColumnTypeName(i);

			System.out.println(colName + " -> " + colType);
		}

		rs.close();
		st.close();
		conn.close();

	}

}
