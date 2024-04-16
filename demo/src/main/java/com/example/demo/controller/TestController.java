package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@PostMapping("/test_controller")
	public ResponseEntity<String> getMessageSum(@RequestBody String reqBody){
		System.out.println("===== enter demo api =====");
		return ResponseEntity.status(HttpStatus.OK).body("成功");
	}
}
