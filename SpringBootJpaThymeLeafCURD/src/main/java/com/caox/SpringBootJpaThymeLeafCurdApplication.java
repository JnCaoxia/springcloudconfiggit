package com.caox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJpaThymeLeafCurdApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootJpaThymeLeafCurdApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaThymeLeafCurdApplication.class, args);
	}
}
