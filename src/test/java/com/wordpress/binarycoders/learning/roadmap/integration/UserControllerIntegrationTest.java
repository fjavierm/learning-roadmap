package com.wordpress.binarycoders.learning.roadmap.integration;

import com.wordpress.binarycoders.learning.roadmap.LearningRoadmapApplication;
import com.wordpress.binarycoders.learning.roadmap.dao.UserDao;
import com.wordpress.binarycoders.learning.roadmap.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = LearningRoadmapApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserDao userDao;

	@Test
	public void givenUsername_whenSearchByUsername_thenStatus200() throws Exception {
		this.userDao.save(new User().setUsername("john"));

		mvc.perform(get("/users/search/john")
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath("username", is("john")));
	}
}
