package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.websystique.springboot"})
public class SpringBootRestApiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(SpringBootRestApiApp.class, args);
	}

}
