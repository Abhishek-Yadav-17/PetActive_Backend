package com.petServer.PetActive.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petServer.PetActive.Services.UserService;
import com.petServer.PetActive.entities.UserData;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserData> getUserData() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public Optional<UserData> getAccessory(@PathVariable String id) {
		return userService.getSpecificUser(id);
	}

	@PostMapping("/users")
	public UserData addAcs(@RequestBody UserData ud) {
		return userService.getAddedUser(ud);
	}

	@PutMapping("/users")
	public UserData updateAcs(@RequestBody UserData ud) {
		return userService.getUpdatedUser(ud);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
