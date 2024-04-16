package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class TestController {
	private Integer count = 0;

	@PostMapping("/test_controller")
	public ResponseEntity<String> getMessageSum(@RequestBody String reqBody){
		System.out.println("===== enter demo api =====");
		return ResponseEntity.status(HttpStatus.OK).body("成功");
	}
	
	@GetMapping("/add_1")
	public ResponseEntity<String> add_1(){
		count += 1;
		return ResponseEntity.status(HttpStatus.OK).body("成功");
	}
	
	@GetMapping("/getCurrentCount")
	public ResponseEntity<String> getCurrentCount(){
		System.out.println("current: " + count);
		return ResponseEntity.status(HttpStatus.OK).body("成功");
	}
}
