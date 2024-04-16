package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MyTestService {
	private Integer count = 0;
	
	public void add_1(){
		count += 1;
	}
	
	public void getCurrentCount(){
		System.out.println("current: " + count);
	}
}
