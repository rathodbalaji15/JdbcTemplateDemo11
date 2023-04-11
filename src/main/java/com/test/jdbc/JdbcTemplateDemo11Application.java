package com.test.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateDemo11Application {
	private int id;
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateDemo11Application.class, args);
		System.out.println("This is test line1 for FB branch");
		System.out.println("This is test line2 for FB branch");
	}

}
