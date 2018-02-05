package com.wordpress.binarycoders.learning.roadmap.service.impl;

import com.wordpress.binarycoders.learning.roadmap.dao.UserDao;
import com.wordpress.binarycoders.learning.roadmap.dto.UserDto;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import com.wordpress.binarycoders.learning.roadmap.service.UserService;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserDao userDao;

	@Before
	public void setUp() {
		final User user = new User().setUsername("john.doe");

		when(userDao.findByUsername(user.getUsername())).thenReturn(user);
		when(userDao.toExemplifyQueryDsl(1L)).thenReturn(user);
	}

	@Test
	public void whenValidUsername_thenUserShouldBeFound() {
		final User user = userService.findByUsername("john.doe");

		Assert.assertThat(user.getUsername(), equalTo("john.doe"));
	}

	@Test
	public void whenValidId_thenUserShouldBeFound() {
		final User user = userService.toExemplifyQueryDsl(1L);

		Assert.assertThat(user.getUsername(), equalTo("john.doe"));
	}
}