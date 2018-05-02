package com.bootrest.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.bootrest.emp"})
public class SpringBootRestApiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(SpringBootRestApiApp.class,args);
	}

}
