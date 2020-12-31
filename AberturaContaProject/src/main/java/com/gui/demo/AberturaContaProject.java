package com.gui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gui.demo"})
public class AberturaContaProject {

	public static void main(String[] args) {
		SpringApplication.run(AberturaContaProject.class, args);
	}

}
