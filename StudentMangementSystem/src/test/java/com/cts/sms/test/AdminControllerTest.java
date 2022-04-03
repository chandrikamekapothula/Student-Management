package com.cts.sms.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.sms.StudentManagementSystem;
import com.cts.sms.controller.AdminController;
import com.cts.sms.model.Admin;
import com.cts.sms.service.AdminServiceImpl;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentManagementSystem.class)
@WebAppConfiguration
public class AdminControllerTest {
	
	  @Autowired
	  private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;
	 

	@Autowired
	private AdminController adminController;

	@Autowired 
	Admin a;

	@Autowired
	AdminServiceImpl adminService;
	
	 @Before
	  public void setUp() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }

	 @Test
		public void contextLoads() throws Exception {

			assertThat(adminController).isNotNull();
		}
	 
	@Test
	public void showAdminTest() throws Exception {
		this.mockMvc.perform(get("/admin")).andExpect(status().isOk()).andExpect(view().name("home"))
				.andExpect(forwardedUrl("WEB-INF/views/home.jsp"));
	}

	@Test
	public void showNotAdminTest() throws Exception {
		this.mockMvc.perform(get("/admin1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void submitAdminTest() throws Exception {
		a=new Admin("admin@gmail.com","admin");
				 String email = a.getEmail();
		 String pwd = a.getPassword();
		
		 this.mockMvc.perform(post("/studetail")
				.param("email",email )
				.param("password",pwd))
		.andExpect(status().isOk())
		.andExpect(view().name("details"))
				.andExpect(forwardedUrl("WEB-INF/views/details.jsp"));
	   
	}
	
	@Test
	public void submitFailAdminTest() throws Exception {
		a=new Admin("admin1@gmail.com","admin1");
				 String email = a.getEmail();
		 String pwd = a.getPassword();
		
		 this.mockMvc.perform(post("/studetail")
				.param("email",email )
				.param("password",pwd))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/admin"))
				.andExpect(flash().attribute("msg", is("Invalid Admin Credentials!!!")));
	}
	
}
