package com.shinhan.dockertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTest {
	
	@GetMapping("/test")
	public String f1() {
		return "dockerTestConnectionSuccess";
	}
	@GetMapping("/temp")
	public String temp() {
		return "temp 스프링 접근 완료";
	}
	@GetMapping("/tt")
	public String temp2() {
		return "tt 스프링 접근 완료";
	}
	@GetMapping("/temp2")
	public String temp3() {
		return "temp2 스프링 접근 완료";
	}
	
	@GetMapping("/temp3")
	public String temp4() {
		return "temp3 스프링 접근 완료";
	}
}
