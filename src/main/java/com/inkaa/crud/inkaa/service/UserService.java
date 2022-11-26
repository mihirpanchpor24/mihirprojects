package com.inkaa.crud.inkaa.service;

import java.util.List;
import com.inkaa.crud.inkaa.entity.User;

// Describes the business logic of the Spring-boot Application

public interface UserService {

	// Save operation
	User saveUser(User user);

	// Read operation
	List<User> fetchUserList();

	// Fetch operation for a specific user
	User getUserById(Long userId);

	// Update operation
	User updateUser(User user, Long userId);

	// Delete operation
	void deleteUserById(Long userId);

}
