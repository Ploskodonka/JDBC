package com.epam.tanya_adnokulova.java.lesson7.task2;

import java.sql.Date;

public class EmpTable {
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public EmpTable(String ename, String job, int  mgr, Date hiredate, int sal, int comm, int deptno) {
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public String getJob() {
		return job;
	}
	
	public int getMgr() {
		return mgr;
	}
	
	public Date getHiredare() {
		return hiredate;
	}
	
	public int getSal() {
		return sal;
	}

	public int getComm() {
		return comm;
	}
	
	public int getDeptno() {
		return deptno;
	}
}
