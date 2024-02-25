package com.practice.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.Entity.UserInfo;
import com.practice.security.repository.UserInfoRepository;
import com.practice.security.service.UserInfoService;

@RestController
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	UserInfoRepository repo;

	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserInfo> getAllUsers() {
		
		return userInfoService.getUserByName();
	}
	@PostMapping("/saveuser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String saveUsers(@RequestBody UserInfo user) {
		
		  userInfoService.saveUser(user);
		  return"success";
	}
	@PostMapping("/anything")  
	public String sampleStringMethod() {
		return "I am back";
	}
	@GetMapping("/say")  
	public String sampleStringMethod2() {
		return "authorized method";
	}
}
