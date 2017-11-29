package com.spring.hbm.mapping.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hbm.mapping.api.service.UserService;
import com.spring.hbm.mapping.dto.UserRequest;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserRequest request) {
		return service.saveUser(request);
	}

	@GetMapping("/getUserWithVeichle")
	public List<Object> getUserWithVeichle() {
		return service.getUserAndVeichleInfo();
	}

	@GetMapping("/getUser_Join_Veichle")
	public Map<String, Object> getUserVeichle() {
		return service.getUserAndVeichle();
	}

	@GetMapping("/getUser_Join_Business")
	public Map<String, Object> getUserBusiness() {
		return service.getUserAndBusiness();
	}

	@GetMapping("/getUser_Join_all")
	public Map<String, Object> getUserAllMappingInfo() {
		return service.getUserAllMapping();
	}
}
