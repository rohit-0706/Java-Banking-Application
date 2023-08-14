package com.rohit.bankingProject;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jdk.jfr.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Rohit Banking application",
				description = "Backend Rest APIs for this project",
				version = "v1.0",
				contact = @Contact(
						name = "Rohit Verma",
						email = "rv16verma@gmail.com",
						url = "https://github.com/rohit-0706/Java-Banking-Application"
				),
				license = @License(
						name = "Rohit Banking Application",
						url = "https://github.com/rohit-0706/Java-Banking-Application"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Rohit Banking Application Documentation",
				url = "https://github.com/rohit-0706/Java-Banking-Application"

		)
)
public class BankingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingProjectApplication.class, args);
	}

}
