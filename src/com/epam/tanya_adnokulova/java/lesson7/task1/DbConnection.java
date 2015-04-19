package com.epam.tanya_adnokulova.java.lesson7.task1;

import java.sql.SQLException;

public interface DbConnection {
	public void process() throws ClassNotFoundException, SQLException;
	public void close() throws SQLException;
}
