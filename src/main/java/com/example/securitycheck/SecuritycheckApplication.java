package com.example.securitycheck;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SecuritycheckApplication {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.securitycheck")).paths(getPaths()).build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> getPaths() {
		return or(regex("/token.*"),regex("/organization.*"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SecuritycheckApplication.class, args);
	}
}
