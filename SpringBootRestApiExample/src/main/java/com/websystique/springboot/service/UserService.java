package com.websystique.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.websystique.springboot.model.User;

@Service
public interface UserService {

	List<User> findAllUsers();
	
	void updateUser(User currentUser);
	void deleteAllUsers();
	void saveUser(User user);
	User findById(long id);
    void deleteUserById(long id);
    boolean isUserExist(User user);
	
	
}
