package com.emp.server.service;

import java.util.List;



import com.emp.server.model.Emp;


public interface EmpService {

	
	Emp findByEmpno(int empno);
	int createEmp(Emp emp);
	int updateEmp(Emp emp);
	int deleteEmpByEmpno(int empno);
	List<Emp> getAllEmps();
	boolean isEmpExist(Emp emp);
}
