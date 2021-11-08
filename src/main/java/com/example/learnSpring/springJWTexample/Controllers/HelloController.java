package com.example.learnSpring.springJWTexample.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/springJWTexample")
public class HelloController {

	@GetMapping("/helloWorld")
	public String getHelloWorld() {
		
		return "Hello World! Subash";
	}
}
