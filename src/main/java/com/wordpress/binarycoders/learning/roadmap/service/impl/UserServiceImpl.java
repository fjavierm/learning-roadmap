package com.wordpress.binarycoders.learning.roadmap.service.impl;

import com.wordpress.binarycoders.learning.roadmap.dao.UserDao;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import com.wordpress.binarycoders.learning.roadmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUsername(final String username) {
		return this.userDao.findByUsername(username);
	}

	@Override
	public User toExemplifyQueryDsl(final Long id) {
		return this.userDao.toExemplifyQueryDsl(id);
	}
}
