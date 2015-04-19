package com.epam.tanya_adnokulova.java.lesson7.task1;

public class ConnectionFactory {
	public DbConnection createConnection(String dbType) {
		if (dbType == null)
			return null;
		if ("oracle".equalsIgnoreCase(dbType))
			return new OracleConnection();
		if ("access".equalsIgnoreCase(dbType))
			return new MSAccessConnection();
		return null;
	}

}
