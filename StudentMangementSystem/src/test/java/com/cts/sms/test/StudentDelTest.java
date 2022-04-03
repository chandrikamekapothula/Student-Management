package com.cts.sms.test;

import static org.assertj.core.api.Assertions.assertThat;

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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.sms.StudentManagementSystem;
import com.cts.sms.controller.StudentAddController;
import com.cts.sms.controller.StudentDeleteController;
import com.cts.sms.model.Admin;
import com.cts.sms.model.Student;
import com.cts.sms.repository.StudentDao;
import com.cts.sms.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentManagementSystem.class)
@WebAppConfiguration
public class StudentDelTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Autowired
	private StudentDeleteController stuController;

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
	public void submitDelTest() throws Exception {
		when(repo.deleteStudentDetails(anyInt())).thenReturn(0);
		when(repo.viewStudentDetails(anyInt())).thenReturn(null);
		// System.out.println(service.viewStudentDetails(anyInt()));
		//System.out.println(service.deleteStudentDetails(anyInt()));
		mockMvc.perform(post("/submitstudel")).andExpect(status().isOk()).andExpect(view().name("studentdel"))
				.andExpect(forwardedUrl("WEB-INF/views/studentdel.jsp"))
				.andExpect(result-> assertEquals(0,service.deleteStudentDetails(anyInt())))
				.andExpect(model().attribute("msg", "Student Id Doesnot exist"));
		
	}
}
