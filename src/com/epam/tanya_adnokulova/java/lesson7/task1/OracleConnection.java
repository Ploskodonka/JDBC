package com.epam.tanya_adnokulova.java.lesson7.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements DbConnection {
	Connection connection = null;

	@Override
	public void process() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "TATYANA_ADNOKULOVA";
		String password = "123";
	
		Class.forName(driverName);
		connection = DriverManager.getConnection(url, user, password);
		this.connection = connection;
		System.out.println("You've successfully connected to Oracle database");
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) { 
			connection.close();
			System.out.println("Connection with Oracle is closed");
		}
	}
}

