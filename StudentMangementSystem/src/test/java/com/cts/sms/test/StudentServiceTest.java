package com.cts.sms.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.sms.model.Student;
import com.cts.sms.repository.StudentDao;
import com.cts.sms.service.StudentService;
import com.cts.sms.service.StudentServiceImpl;


public class StudentServiceTest {

	@Mock
	StudentDao repo;

	@InjectMocks
	StudentServiceImpl service;
	private Student s;
	

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		 s = new Student(1001,"abc","male","abc@gmail.com","20-01-2000","fff","mmm","9087654312");
	}

	@Test
	public void calculateGradeTest() {

		List<Integer> marks = new ArrayList<Integer>();
		marks.add(20);
		marks.add(90);
		marks.add(70);
		int sum = 0;
		for (int i = 0; i < marks.size(); i++)
			sum = sum + marks.get(i);

		
		when(repo.getMarks(anyInt())).thenReturn(sum);

		assertEquals("C", service.calculateGrade(sum));

	}
	
	@Test
	public void addStudentTest() throws ParseException {

		
		when(repo.addStudentDetails(s)).thenReturn(1);
		assertEquals(1,service.addStudentDetails(s));
	}
	
	@Test
	public void deleteStudentTest()  {

		
		when(repo.deleteStudentDetails(anyInt())).thenReturn(1);
		assertEquals(1,service.deleteStudentDetails(anyInt()));
	}

	@Test
	public void editStudentTest()  {

		when(repo.viewStudentDetails(anyInt())).thenReturn(null);
		assertEquals(0,service.updateStudentDetails(null,1));
	}
	
	@Test
	public void viewStudentTest()   {
		
	
		when(repo.viewStudentDetails(s.getId())).thenReturn(s);
		
		assertEquals(s,service.viewStudentDetails(s.getId()));
	}
}
