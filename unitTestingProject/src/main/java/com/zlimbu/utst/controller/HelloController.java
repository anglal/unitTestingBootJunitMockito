package com.zlimbu.utst.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

}


//@WebMvcTest(HelloWorldController.class)