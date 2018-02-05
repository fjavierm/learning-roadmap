package com.wordpress.binarycoders.learning.roadmap.dao;

import com.wordpress.binarycoders.learning.roadmap.dao.custom.UserDaoCustom;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>, UserDaoCustom {

	User findByUsername(String username);
}
