package com.bootrest.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootrest.emp.model.Emp;

@Service
public interface EmpService {

	List<Emp> findAllEmps();
	void updateEmp(Emp currentEmp);
	void deleteAllEmps();
	void saveEmp(Emp emp);
	Emp findByEno(int empno);
	void deleteEmpByEno(int empno);
	boolean isEmpExist(Emp emp);
}
