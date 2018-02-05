package com.wordpress.binarycoders.learning.roadmap.service;

import com.wordpress.binarycoders.learning.roadmap.entity.User;

public interface UserService {

	User findByUsername(String username);

	User toExemplifyQueryDsl(Long id);
}
