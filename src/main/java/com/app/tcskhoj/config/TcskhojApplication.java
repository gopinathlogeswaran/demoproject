package com.app.tcskhoj.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.app.tcskhoj.entity")
@EnableJpaRepositories("com.app.tcskhoj.repository")
@SpringBootApplication(scanBasePackages = "com.app.tcskhoj")
public class TcskhojApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcskhojApplication.class, args);
	}

}
