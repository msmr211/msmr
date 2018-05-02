package com.bootrest.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.emp.model.Emp;
import com.bootrest.emp.repository.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<Emp> findAllEmps() {
		// TODO Auto-generated method stub
		return empMapper.findAllEmps();
	}

	@Override
	public void updateEmp(Emp currentEmp) {
		// TODO Auto-generated method stub
		
		empMapper.updateEmp(currentEmp);

	}

	@Override
	public void deleteAllEmps() {
		// TODO Auto-generated method stub

		empMapper.deleteAllEmps();
	}

	@Override
	public void saveEmp(Emp emp) {
		// TODO Auto-generated method stub

		empMapper.saveEmp(emp);
	}

	@Override
	public Emp findByEno(int empno) {
		// TODO Auto-generated method stub
		return empMapper.findByEno(empno);
	}

	@Override
	public void deleteEmpByEno(int empno) {
		// TODO Auto-generated method stub

		empMapper.deleteEmpByEno(empno);
	}

	@Override
	public boolean isEmpExist(Emp emp) {
		// TODO Auto-generated method stub
		if(emp == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
