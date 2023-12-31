package com.example.my_spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MySpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringProjectApplication.class, args);
	}

}
