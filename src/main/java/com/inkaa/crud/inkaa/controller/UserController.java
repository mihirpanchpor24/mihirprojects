package com.inkaa.crud.inkaa.controller;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inkaa.crud.inkaa.entity.User;
import com.inkaa.crud.inkaa.service.UserService;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Save operation
	@PostMapping("/adduser")

	public User saveUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	// Read operation
	@GetMapping("/getuser")
	@RolesAllowed("admin")
	public List<User> fetchUserList() {
		return userService.fetchUserList();
	}

	@GetMapping("/getuser/{id}")
	@RolesAllowed("user")
	public User showUser(@PathVariable("id") Long userId) {
		return userService.getUserById(userId);
	}

// Update operation
	@PutMapping("/edituser/{id}")

	public User updateUser(@RequestBody User user, @PathVariable("id") Long userId) {
		return userService.updateUser(user, userId);
	}

	// Delete operation
	@DeleteMapping("/deleteuser/{id}")

	public String deleteUserById(@PathVariable("id") Long userId) {
		userService.deleteUserById(userId);
		return "Deleted Successfully";
	}

}
