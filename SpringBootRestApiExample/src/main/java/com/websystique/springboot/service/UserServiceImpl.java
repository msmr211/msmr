package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springboot.model.User;
import com.websystique.springboot.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.findAllUsers();
	}

	
	@Override
	public void updateUser(User currentUser) {
		// TODO Auto-generated method stub
		userMapper.updateUser(currentUser);

	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userMapper.deleteAllUsers();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.saveUser(user);

	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}

	
	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userMapper.deleteUserById(id);

	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		if(user == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
