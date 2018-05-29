package com.emp.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.emp.server.model.Emp;

@Mapper
public interface EmpMapper {

	public int insert(Emp emp);
	public int update(Emp emp);
	public int deleteByEmpNo(int empno);
	
	@Select("Select * FROM employee")
	public List<Emp> findAllEmps();
	
	@Select("SELECT * FROM employee WHERE empno = #{empno}")
	public Emp selectByEmpNo(int empno);
	
	public int increment(int empno);
	
}
