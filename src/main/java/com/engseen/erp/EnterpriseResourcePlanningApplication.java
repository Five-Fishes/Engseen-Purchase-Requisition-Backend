package com.engseen.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EnterpriseResourcePlanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseResourcePlanningApplication.class, args);
	}

}
