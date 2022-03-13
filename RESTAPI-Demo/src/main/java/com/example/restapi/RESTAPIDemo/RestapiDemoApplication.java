package com.example.restapi.RESTAPIDemo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestapiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiDemoApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
	AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
	//	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
//	@Bean//Be careful about the name of the method -should be messageSource
//	public ResourceBundleMessageSource bundlerMessageSource()
//   {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//   }
}
