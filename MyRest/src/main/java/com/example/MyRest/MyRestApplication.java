package com.example.MyRest;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		scanBasePackages = {"com.example"})
public class MyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Bean " + getClass().getSimpleName() + " has been constructed!");
	}

	@PreDestroy
	public void onDestroy() {
		System.out.println("Bean " + getClass().getSimpleName() + " is being destroyed!");
	}

	@Bean
	public CommandLineRunner commandRun(String[] args) {
		return runner -> {
			System.out.println("This is a command line runner!");
		};
	}

}
