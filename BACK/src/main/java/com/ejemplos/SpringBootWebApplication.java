package com.ejemplos;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	// Conectar angular con spring
//	@Bean
//
//	public WebMvcConfigurer corsConfigurer() {
//
//		return new WebMvcConfigurer() {
//
//			@Override
//
//			public void addCorsMappings(CorsRegistry registry) {
//
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*")
//						.allowedHeaders("*")
//						.allowCredentials(true);
//
//			}
//
//		};
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
	}


