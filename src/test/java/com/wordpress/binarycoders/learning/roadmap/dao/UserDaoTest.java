package com.wordpress.binarycoders.learning.roadmap.dao;

import com.wordpress.binarycoders.learning.roadmap.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserDao userDao;

	@Test
	public void findOneTest() {
		final User user = this.entityManager.persist(new User().setUsername("john.doe"));

		this.entityManager.flush();

		assertThat(this.userDao.findOne(user.getId()), notNullValue());
	}

	@Test
	public void findByUsername() {
		final User user = this.entityManager.persist(new User().setUsername("john.doe"));

		this.entityManager.flush();

		assertThat(this.userDao.findByUsername(user.getUsername()), notNullValue());
		assertThat(this.userDao.findByUsername("jane.doe"), nullValue());
	}
}