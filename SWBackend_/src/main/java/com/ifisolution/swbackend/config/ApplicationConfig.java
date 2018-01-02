package com.ifisolution.swbackend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.ifisolution.swbackend.*"})
@EnableJpaRepositories("com.ifisolution.swbackend.repository")
@EntityScan("com.ifisolution.swbackend.model") 
public class ApplicationConfig{ 

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

	
}

