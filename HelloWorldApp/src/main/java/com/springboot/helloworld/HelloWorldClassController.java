package com.springboot.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldClassController {
	@RequestMapping(value = "/")
	public String hellow() {
		return "Welcome to First Programme in Spring Boot using Spring Approach By Ravi Ranjan";
	}
	/*
	 *
	 * HelloWorldClass obj=new HelloWorldClass(); obj.getHelloWorld();
	 */
}
