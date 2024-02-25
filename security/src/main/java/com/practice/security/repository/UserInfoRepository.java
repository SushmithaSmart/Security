package com.practice.security.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.security.Entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	
}
