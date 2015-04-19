package com.epam.tanya_adnokulova.java.lesson7.task2;

import java.sql.SQLException;

/**
 * 
 * @author Tanya Adnokulova
 * lesson 7 task 2
 *
 */

public class Runner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbConnection run = new DbConnection();
		run.employeeTable();
	}

}
