package com.cts.sms.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.sms.StudentManagementSystem;
import com.cts.sms.controller.StudentDeleteController;
import com.cts.sms.controller.StudentViewController;
import com.cts.sms.model.Admin;
import com.cts.sms.model.Student;
import com.cts.sms.repository.StudentDao;
import com.cts.sms.service.StudentServiceImpl;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentManagementSystem.class)
@WebAppConfiguration
public class StudentViewControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Autowired
	private StudentViewController stuController;

	@Autowired
	Admin a;

	@Autowired
	Student s;

	@Mock
	StudentDao repo;

	@InjectMocks
	StudentServiceImpl service;

	@Before
	public void before() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		s = new Student(1001, "abc", "male", "abc@gmail.com", "20-01-2000", "fff", "mmm", "9087654312");
	}

	@Test
	public void contextLoads() throws Exception {

		assertThat(stuController).isNotNull();
	}

	@Test
	public void submitviewTest() throws Exception {

		when(repo.viewStudentDetails(anyInt())).thenReturn(s);

		mockMvc.perform(post("/submitstuview").param("id", Integer.toString(1001))).andExpect(status().isOk())
				.andExpect(view().name("studentview")).andExpect(forwardedUrl("WEB-INF/views/studentview.jsp"))
				.andExpect(result -> assertEquals(s, service.viewStudentDetails(anyInt())));
		// .andExpect(model().attribute("msg", "Student Id Doesnot exist"));
		// .andExpect(model().attribute("student1",hasProperty("id", is(anyInt()))));

	}

	@Test
	public void submitviewFailTest() throws Exception {

		when(repo.viewStudentDetails(anyInt())).thenReturn(null);

		mockMvc.perform(post("/submitstuview").param("id", Integer.toString(1005))).andExpect(status().isOk())
				.andExpect(view().name("studentview")).andExpect(forwardedUrl("WEB-INF/views/studentview.jsp"))
				.andExpect(result -> assertEquals(null, service.viewStudentDetails(anyInt())))
		 .andExpect(model().attribute("msg", "Record Not Found"));
		// .andExpect(model().attribute("student1",hasProperty("id", is(anyInt()))));

	}

}
