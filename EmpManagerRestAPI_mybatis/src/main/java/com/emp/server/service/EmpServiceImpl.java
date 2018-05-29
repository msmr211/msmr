package com.emp.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.server.mapper.EmpMapper;
import com.emp.server.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public Emp findByEmpno(int empno) {
		// TODO Auto-generated method stub
		Emp emp =  empMapper.selectByEmpNo(empno);
		return emp;
	}

	@Override
	public int createEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.insert(emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.update(emp);
	}

	@Override
	public int deleteEmpByEmpno(int empno) {
		// TODO Auto-generated method stub
		return empMapper.deleteByEmpNo(empno);
	}

	@Override
	public List<Emp> getAllEmps() {
		// TODO Auto-generated method stub
		return empMapper.findAllEmps();
	}

	@Override
	public boolean isEmpExist(Emp emp) {
		if(empMapper.selectByEmpNo(emp.getEmpno())!=null){

			return true;

		}else {

			return false;			

		}

	}

}
