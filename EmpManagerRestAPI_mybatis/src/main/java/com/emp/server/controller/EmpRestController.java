package com.emp.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.emp.server.error.CustomErrorType;
import com.emp.server.model.Emp;
import com.emp.server.service.EmpService;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
@RequestMapping("/api")
public class EmpRestController {

	public static final Logger logger = LoggerFactory.getLogger(EmpRestController.class);
	
	@Autowired
	EmpService empService;
	
	//모든사원
	//Get 매핑으로 할경우 웹스퀘어 에서 못받음
	@PostMapping("/emp.post")
	public ResponseEntity<List<Emp>>getAllEmp(){
		logger.info("get All emps {}");
		List<Emp> emps = empService.getAllEmps();
		return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
	}
	
	
	//사번으로 사원 한명 조회
	@GetMapping("/emp/{empno}")
	public ResponseEntity<Emp> getEmpByEmpno(@PathVariable("empno")int empno){
		logger.info("Fetching Emp with empno {}",empno);
		Emp emp = empService.findByEmpno(empno);
		if(!empService.isEmpExist(emp)) {
			logger.error("사원이 존재하지 않습니다. ", empno);
			return new ResponseEntity(new CustomErrorType("해당 사번"+empno+"를 가지고 있는 사원이 존재하지 않습니다."), HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Emp>(emp, HttpStatus.OK);
		
		
	}
	
	//사원생성
	
	@PostMapping("/emp/")
	public ResponseEntity<?> createEmp(@RequestBody Emp emp, UriComponentsBuilder ucBuilder){
	
		logger.info("Creating Employee: {}", emp);
		if(empService.isEmpExist(emp)) {
			logger.error("사번중복, 사원이 이미 존재합니다.",emp.getEname());
			return new ResponseEntity(new CustomErrorType("사원을 생성할수 없습니다. 해당사원 [사번"+emp.getEmpno()+"][이름:"+emp.getEname()+"]이 이미 존재합니다."),HttpStatus.CONFLICT);
			
		}
		
		empService.createEmp(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/emp/{empno}").buildAndExpand(emp.getEmpno()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
		
	
		
		
	}
	
	//사원정보수정
		@PutMapping("/emp/")
		public ResponseEntity<?> updateEmp(@PathVariable("empno")int empno, @RequestBody Emp emp){
			
			logger.info("Updating Emp with empno {}", empno);
			if(!empService.isEmpExist(emp)) {
				logger.error("사원이 존재하지 않습니다.", empno);
				return new ResponseEntity(new CustomErrorType("해당 사번"+empno+"를 가지고 있는 사원이 존재하지 않습니다."), HttpStatus.NOT_FOUND);
				
			}
			
			Emp currentEmp = emp;
			currentEmp.setSalary(emp.getSalary());
			currentEmp.setEname(emp.getEname());
			currentEmp.setJob(emp.getJob());
			
			empService.updateEmp(currentEmp);
			return new ResponseEntity<Emp>(currentEmp, HttpStatus.OK);
		}
			
	
		//사원삭제
		@DeleteMapping("/emp/{empno}")
		public ResponseEntity<?> deleteEmp(@PathVariable("empno")int empno){
			
			logger.info("Fetching & Deleting Emp with empno {}", empno);
			Emp emp = empService.findByEmpno(empno);
			if(!empService.isEmpExist(emp)) {
				logger.error("삭제할 수 없습니다. 사원이 이미 존재하지 않습니다.", empno);
				return new ResponseEntity(new CustomErrorType("해당 사번"+empno+"를 가지고 있는 사원이 존재하지 않습니다."),HttpStatus.NOT_FOUND);
				
			}
			
			empService.deleteEmpByEmpno(empno);
			return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
			
		}
		
		
}
