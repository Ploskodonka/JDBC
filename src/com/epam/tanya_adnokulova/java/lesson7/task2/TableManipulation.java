package com.epam.tanya_adnokulova.java.lesson7.task2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TableManipulation {
	private List<EmpTable> empList = new ArrayList<EmpTable>();
	
	public void addRecordsFromEmp (Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM EMP");
			
			while (rs.next()) {
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				int mgr = rs.getInt("MGR");
				Date hiredate = rs.getDate("HIREDATE");
				int sal = rs.getInt("SAL");
				int comm = rs.getInt("COMM");
				int deptno = rs.getInt("DEPTNO");
				empList.add(new EmpTable(ename, job, mgr, hiredate, sal, comm, deptno));
			}	
			
			System.out.println("Records were added to arraylist");
		} finally {
			if (rs != null)
				rs.close();
			if (statement != null) 
				statement.close();
		} 
	}
	
	public void insertRecords (Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement insert = null;
		int MaxEmpno = 0;
		
		try {
			statement = connection.createStatement();
			String queryMaxEmpno = "SELECT MAX(EMPNO) FROM EMP";
			rs = statement.executeQuery(queryMaxEmpno);
			if (rs.next())
				MaxEmpno = rs.getInt(1);
			insert = connection.prepareStatement("INSERT INTO EMP VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < empList.size(); j++) {
					MaxEmpno++;
					EmpTable tmp = empList.get(j);
					insert.setInt(1, MaxEmpno);
					insert.setString(2, tmp.getEname());
					insert.setString(3, tmp.getJob());
					insert.setInt(4, tmp.getMgr());
					insert.setDate(5, tmp.getHiredare());
					insert.setInt(6, tmp.getSal());
					insert.setInt(7, tmp.getComm());
					insert.setInt(8, tmp.getDeptno());
					insert.executeUpdate();
				}	
			}
			
			System.out.println("Scott.EMP table has been successfully modified");
		} finally {
			if (rs != null)
				rs.close();
			if (statement != null) 
				statement.close();
			if (insert != null)
				insert.close();
		}		
	}
}
