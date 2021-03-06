package com.example.restapi.RESTAPIDemo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//http://localhost:8081/swagger-ui/index.html
@Configuration //configuration file
@EnableWebMvc
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Bharti","google.com ","abc@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title","Awesome API Documentation","1.0","urn:tos","DEFAULT_CONTACT","Apache 2.0","http://www.apache.org/licenses/LICENSE-2.0");
	//private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = null;
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	@Bean
	public Docket api() {
	
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
		       .produces(DEFAULT_PRODUCES_AND_CONSUMES)
		      .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
				//.consumes(consumesAndProduces)
				//.produces(consumesAndProduces)
				//.pathMapping("/");
	}
	

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("My awesome API")
			.description("My awesome API Description")
				.version("1.0")
				.contact(new Contact("Ranga", "http://www.in28minutes.com",
						"in28minutes@gmail.com"))
			.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
	// Bean - Docket
	// Swagger 2
	// All the paths
	// All the apis


}