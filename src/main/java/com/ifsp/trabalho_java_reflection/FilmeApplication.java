package com.ifsp.trabalho_java_reflection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class FilmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeApplication.class, args);
	}
}