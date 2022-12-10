package com.soyfri.interview.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfiguration {

	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Technical Interview")
	              .description("Spring sample application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	  }
	
}