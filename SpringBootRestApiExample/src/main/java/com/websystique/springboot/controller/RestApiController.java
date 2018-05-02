package com.websystique.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.User;
import com.websystique.springboot.service.UserServiceImpl;
import com.websystique.springboot.util.CustomErrorType;

/*@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)*/
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired

	UserServiceImpl userService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)

	public ResponseEntity<List<User>> listAllUsers() {

		logger.info("Select All Users");

		List<User> users = userService.findAllUsers();

		if (users.isEmpty()) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)

	public ResponseEntity<?> getUser(@PathVariable("id") long id) {

		logger.info("Fetching User with id {}", id);

		User user = userService.findById(id);

		if (user == null) {

			logger.error("User with id {} not found.", id);

			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)

	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {

			logger.error("Unable to create. A User with name {} already exist", user.getName());

			return new ResponseEntity(
					new CustomErrorType("Unable to create. A User with name " + user.getName() + " already exist."),
					HttpStatus.CONFLICT);

		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)

	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {

		logger.info("Updating User with id {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {

			logger.error("Unable to update. User with id {} not found.", id);

			return new ResponseEntity(new CustomErrorType("Unable to update. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);

		}

		currentUser.setName(user.getName());

		currentUser.setAge(user.getAge());

		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);

		return new ResponseEntity<User>(currentUser, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)

	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		logger.info("Fetching & Deleting User with id {}", id);

		User user = userService.findById(id);

		if (user == null) {

			logger.error("Unable to delete. User with id {} not found.", id);

			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);

		}

		userService.deleteUserById(id);

		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)

	public ResponseEntity<User> deleteAllUsers() {

		logger.info("Deleting All Users");

		userService.deleteAllUsers();

		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

	}

}
