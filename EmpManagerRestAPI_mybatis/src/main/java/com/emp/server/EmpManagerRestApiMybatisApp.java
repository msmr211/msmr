package com.emp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.emp.server"})
public class EmpManagerRestApiMybatisApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(EmpManagerRestApiMybatisApp.class, args);
		
	}

}
