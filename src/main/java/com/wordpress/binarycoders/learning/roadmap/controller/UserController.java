package com.wordpress.binarycoders.learning.roadmap.controller;

import com.wordpress.binarycoders.learning.roadmap.dto.UserDto;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import com.wordpress.binarycoders.learning.roadmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable final Long id) {
		final User user = this.userService.toExemplifyQueryDsl(id);

		return ResponseEntity.ok(user.toDto());
	}

	@GetMapping("/search/{username}")
	public ResponseEntity<UserDto> searchByUsername(@PathVariable final String username) {
		final User user = this.userService.findByUsername(username);

		return ResponseEntity.ok(user.toDto());
	}
}
