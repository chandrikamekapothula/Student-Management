package com.cts.sms.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.sms.StudentManagementSystem;
import com.cts.sms.controller.AdminController;
import com.cts.sms.model.Admin;
import com.cts.sms.service.AdminServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=StudentManagementSystem.class)
public class AdminServiceTest {
	
	@Autowired
	AdminServiceImpl adminService;

	private Admin a;
	
	
	
	@Before
	public void adminSetup()
	{
		a=new Admin();
	}
	
	
	@Test
	public void test1()
	{
		
		a.setEmail("ad@g.com");
		a.setPassword("ad1");
		boolean result = adminService.autheticateAdmin(a);
		assertEquals(false,result);
	}
	
	@Test
	public void test2()
	{
		
		a.setEmail("admin@gmail.com");
		a.setPassword("admin");
		boolean result = adminService.autheticateAdmin(a);
		assertEquals(true,result);
	}
}
