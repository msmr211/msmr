package com.emp.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class Emp {

	private int empno;
	private String ename;
	private String job;
	private int salary;
	private Date hireDate;
	
	
}
