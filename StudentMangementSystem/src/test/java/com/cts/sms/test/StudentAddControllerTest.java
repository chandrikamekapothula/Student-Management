package com.cts.sms.test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import com.cts.sms.controller.StudentAddController;
import com.cts.sms.model.Admin;
import com.cts.sms.model.Student;
import com.cts.sms.repository.StudentDao;
import com.cts.sms.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentManagementSystem.class)
@WebAppConfiguration
public class StudentAddControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Autowired
	private StudentAddController stuController;

	@Autowired
	Admin a;

	@Mock
	StudentDao repo;

	@InjectMocks
	StudentServiceImpl service;

	private Student s;

	@Autowired
	private ObjectMapper objectMapper;

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

	
	  @Test public void submitAddTest() throws Exception {
	  
	  this.mockMvc.perform(post("/submitstuadd")
		
		  .param("id", Integer.toString(1007)) .param("name", "aaaaa") .param("gender",
		  "female") .param("email", "aaa@gmail.com") .param("dob","30-08-2004")
		  .param("fname", "ffff") .param("mname", "mmmm") .param("phno","9638527410")
		 
		
		  .param("marks1", Integer.toString(0)) .param("marks2",  Integer.toString(0)) .param("marks3", Integer.toString(0))
		  .param("grade", "null")
		 
			  )
	  .andDo(print())
	  .andExpect(status().isOk())
	  .andExpect(view().name("studentadd"))
	  .andExpect(forwardedUrl("WEB-INF/views/student.jsp"))
	  .andExpect(flash().attribute("msg", "successful"));
	  }
	 
	 

	/*
	 * @Test public void submitFailAdminTest() throws Exception { a = new
	 * Admin("admin1@gmail.com", "admin1"); String email = a.getEmail(); String pwd
	 * = a.getPassword();
	 * 
	 * this.mockMvc.perform(post("/studetail").param("email",
	 * email).param("password", pwd))
	 * .andExpect(status().isFound()).andExpect(view().name("redirect:/admin"))
	 * .andExpect(flash().attribute("msg", is("Invalid Admin Credentials!!!"))); }
	 */

}
