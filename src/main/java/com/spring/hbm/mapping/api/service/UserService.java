package com.spring.hbm.mapping.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hbm.mapping.api.model.User;
import com.spring.hbm.mapping.api.repository.UserMappingRepository;
import com.spring.hbm.mapping.dto.UserRequest;

@Service
public class UserService {
	@Autowired
	private UserMappingRepository repository;

	public String saveUser(UserRequest request) {
		User user = request.getUser();
		user.setBusiness(request.getBusiness());
		user.setAddress(request.getAddress());
		user.setVeichle(request.getVeichle());
		repository.SaveUser(user);
		return "user id : " + user.getUserid() + " mapping perfectly one-to-many with " + request.getBusiness().size()
				+ " Business and one-to-one with address and many to one with Veichle ";
	}

	public List<Object> getUserAndVeichleInfo() {
		return repository.getUserAndVeichleInfo();
	}

	public Map<String, Object> getUserAndVeichle() {
		return repository.getUserVeichleInfo();
	}

	public Map<String, Object> getUserAndBusiness() {
		return repository.getUserBusinessInfo();
	}
	public Map<String, Object> getUserAllMapping() {
		return repository.getUserAllMapingInfo();
	}
}
