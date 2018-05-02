package com.bootrest.emp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bootrest.emp.model.Emp;

@Mapper
public interface EmpMapper {

	@Insert("INSERT INTO emp(name,dep,salary) VALUES(#{name},#{dep},#{salary})")
	void saveEmp(Emp emp);
	
	@Update("UPDATE emp SET name= #{name}, dep= #{dep}, salary=#{salary} WHERE empno = #{empno} ")
	void updateEmp(Emp currentEmp);
	
	@Delete("DELETE FROM emp WHERE empno = #{empno}")
	void deleteEmpByEno(int empno);
	
	@Delete("DELETE FROM emp")
	void deleteAllEmps();

	boolean isEmpExist(Emp emp);
	
	@Select("SELECT * FROM emp WHERE empno = #{empno}")
	Emp findByEno(int empno);
	
	@Select("SELECT * FROM emp ORDER BY empno")
	@ResultType(Emp.class)
	List<Emp> findAllEmps();
	
	
	
}
