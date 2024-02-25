package com.practice.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practice.security.Entity.UserInfo;
import com.practice.security.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository UserInfoRepository;
	
	public List<UserInfo> getUserByName() {
		List<UserInfo> allUsers = UserInfoRepository.findAll();
		return allUsers;
	}
	 public UserInfo saveUser(UserInfo user) {
	        return UserInfoRepository.save(user);
	    }
}
