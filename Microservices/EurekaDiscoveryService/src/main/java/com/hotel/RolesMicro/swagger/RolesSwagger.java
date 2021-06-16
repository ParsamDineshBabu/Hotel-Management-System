package com.hotel.RolesMicro.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class RolesSwagger {
	@Bean
	public Docket swaggerConfig() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(appInformation());
	}

	private ApiInfo appInformation() {
		return new ApiInfo(
				"Swagger API For Roles Micro",
				"Private API",
				"Using Spring Boot Version",
				"2.3.11", 
				new Contact("Parsam Dinesh Babu","dineshparsam@gmail.com","7989921666"), 
				"Roles",
				"Swagger",
				Collections.emptyList());
	}


}
