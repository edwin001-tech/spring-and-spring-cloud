package com.eduin.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {
	
	//GET 
	//URI - /hello-world
	//Method - 'Hello World'
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//GET http://localhost:8080/hello-world/path-variable/this-is-edwin
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name ) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}


}
