package com.epam.tanya_adnokulova.java.lesson7.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	public void employeeTable() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "tiger";
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("You've successfully connected to database");
			TableManipulation manipulate = new TableManipulation();
			manipulate.addRecordsFromEmp(connection);
			manipulate.insertRecords(connection);
		} finally {
			if (connection != null) {
				connection.close();
				System.out.println("Connection with Oracle is closed");
			}
		}
	}
}

