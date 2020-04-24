package com.expleopune.hr.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EmpexpinfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpexpinfoServiceApplication.class, args);
	}

}
