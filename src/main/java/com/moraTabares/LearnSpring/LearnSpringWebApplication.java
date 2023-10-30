package com.moraTabares.LearnSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller", "models"})
public class LearnSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringWebApplication.class, args);
	}

}
