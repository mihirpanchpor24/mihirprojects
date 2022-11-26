package com.inkaa.crud.inkaa.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.inkaa.crud.inkaa.entity.User;
import com.inkaa.crud.inkaa.repo.UserRepository;

// Describes the method of the business logic 

@Service
@Component
public class UserServiceImpl implements UserService {

	// Links the service implementation with the repository package
	@Autowired
	private UserRepository userRepository;

	// Save operation
	@Override
	public User saveUser(User user) {
		// Pin hashing method
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPin = bcrypt.encode(user.getPin());
		user.setPin(encryptedPin);
		String vuaid = user.getPhoneNumber() + "@ink";
		user.setVuaId(vuaid);
		return userRepository.save(user);
	}

	// Read operation
	@Override
	public List<User> fetchUserList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).get();
	}

	// Delete operation
	@Override
	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
	}

	// Update operation
	@Override
	public User updateUser(User user, Long userId) {

		User userDB = userRepository.findById(userId).get();
		// conditional if statement checks whether user.getFirstName() is not null and
		// an empty string
		if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase( // if the above condition is true, only then
																			// set it to some value
				user.getFirstName())) {
			userDB.setFirstName(user.getFirstName());
		}

		if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
			userDB.setLastName(user.getLastName());
		}

		if (Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())) {
			userDB.setPhoneNumber(user.getPhoneNumber());
		}

		if (Objects.nonNull(user.getPin()) && !"".equalsIgnoreCase(user.getPin())) {
			userDB.setPin(user.getPin());
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			String encryptedPin = bcrypt.encode(user.getPin());
			user.setPin(encryptedPin);
		}

		if (Objects.nonNull(user.getVuaId()) && !"".equalsIgnoreCase(user.getVuaId())) {
			userDB.setVuaId(user.getVuaId());
		}

		return userRepository.save(userDB);
	}

}