package com.inkaa.crud.inkaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.inkaa.crud.inkaa.entity") // Scans POJO class from the entity package
@ComponentScan("com.inkaa.crud.inkaa") // Scans all components from all packages
public class InkApi102Application {

	public static void main(String[] args) {
		SpringApplication.run(InkApi102Application.class, args);
	}

}
