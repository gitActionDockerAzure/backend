package com.shinhan.dockertest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTest {
	
	@CrossOrigin(origins = "*")
	@GetMapping("/test")
	public String f1() {
		return "dockerTestConnectionSuccess";
	}
}
