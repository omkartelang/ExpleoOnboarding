package com.expleopune.hr.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableDiscoveryClient
@EnableJpaAuditing
@SpringBootApplication
public class EducationinfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationinfoServiceApplication.class, args);
	}

}
