package com.epam.tanya_adnokulova.java.lesson7.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSAccessConnection implements DbConnection {
	Connection connection = null;

	@Override
	public void process() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://C:/Users/Tatyana_Adnokulova@epam.com/MyEclipse/JDBC/Tanya.accdb";
		
		Class.forName(driverName);
		connection  = DriverManager.getConnection(url);
		this.connection = connection;
		System.out.println("You've successfully connected to MS Access database");
	}

	@Override
	public void close() throws SQLException {
		if (connection != null) { 
			connection.close();
			System.out.println("Connection with MS Access is closed");
		}
	}
}

