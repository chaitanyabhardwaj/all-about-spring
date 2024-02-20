package com.example.MyRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.example"})
public class MyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApplication.class, args);
	}

}
