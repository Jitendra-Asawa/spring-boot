package com.infoobjects.practice;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * This class is used to read properties from application.properties
 * 
 * @author infoobjects
 *	
 */
@ConfigurationProperties("spring")
public class Configuration {
	//spring.name
	private String name;
	//spring.password
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
