package com.s2e.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.s2e.app.repository.CourseRepository;
//import com.s2e.app.repository.StudentRepository;

@SpringBootApplication
public class CorsiStudentiApplication {

	public static void main(String[] args) {
		// voglio fare qualche test
		// Voglio il context
		// ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(CorsiStudentiApplication.class, args);

//		StudentRepository studentRepo = 
//				configurableApplicationContext.getBean(StudentRepository.class);
//				
//		CourseRepository courseRepo = 
//				configurableApplicationContext.getBean(CourseRepository.class);
	}

}
