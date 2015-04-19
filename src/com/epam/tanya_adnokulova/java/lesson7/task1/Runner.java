package com.epam.tanya_adnokulova.java.lesson7.task1;

import java.sql.SQLException;

/**
 * 
 * @author Tanya Adnokulova
 * lesson 7 task 1
 *
 */

public class Runner {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		if (args.length != 1 || !("oracle".equalsIgnoreCase(args[0]) || "access".equalsIgnoreCase(args[0])))
			throw new  ArrayIndexOutOfBoundsException("Wrong arguments!\nEnter 'oracle' for Oracle DB connection, 'access' for MS Access connection");
		
		DbManipulations run = new DbManipulations();
		
		run.closingAndConnecting(args[0]);
	}

}
