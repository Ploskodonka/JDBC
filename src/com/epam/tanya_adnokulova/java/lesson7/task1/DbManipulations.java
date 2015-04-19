package com.epam.tanya_adnokulova.java.lesson7.task1;

import java.sql.SQLException;


public class DbManipulations {
	
	public void closingAndConnecting(String param) throws SQLException, ClassNotFoundException {
		DbConnection conn = null;
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.createConnection(param);
		} finally {
			conn.process();
			conn.close();	
		}
	}

}
