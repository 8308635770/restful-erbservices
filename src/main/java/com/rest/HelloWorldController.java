package com.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-word-bean")
	public HelloWordBean getHelloWord() {
		return new HelloWordBean("shivam");
	}
	
	@GetMapping("/hello-word-path-variable/{name}")
	public HelloWordBean getHelloWord(@PathVariable String name) {
		return new HelloWordBean(name);
	}

}
