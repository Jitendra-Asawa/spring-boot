package com.infoobjects.userlogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infoobjects.practice.Configuration;

import net.bytebuddy.asm.Advice.This;

//import com.infoobjects.services.CustomerService;

/*
 * IF all the services, repositories, controllers, and 
 * entities are under same package then only annotation 
 * without path specification will work.
 * @ComponentScan is added for scanning the Repositories
 * @EntityScan is added for scanning the Entities
 * 
 * @ComponentScan doesn't work for repositories 
 * We can use @EnableJpaRepositories instead
 * 
 * @EnableConfigurationProperties(Test.class) used to read
 * values from application.properties in a POJO. This is 
 * generally used when we need to read large number of properties.
 * 
 */
@SpringBootApplication
@ComponentScan({ "com.infoobjects.services", "com.infoobjects.userlogin" })
@EntityScan(basePackages = "com.infoobjects.model")
@EnableJpaRepositories("com.infoobjects.repositories")
@EnableConfigurationProperties(Configuration.class)
public class StarterApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(StarterApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
//		SpringApplication.run(UserloginApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
