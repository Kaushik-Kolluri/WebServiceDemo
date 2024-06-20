package com.kaushik.training.webservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kaushik.training")
public class WebServiceDemo {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceDemo.class, args);
	}

}
