package com.example.daouWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
// @SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class DaouWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaouWebApplication.class, args);
	}

}
