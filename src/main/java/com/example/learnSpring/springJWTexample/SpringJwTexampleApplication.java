package com.example.learnSpring.springJWTexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.example.learnSpring.springJWTexample")
public class SpringJwTexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwTexampleApplication.class, args);
	}

}
