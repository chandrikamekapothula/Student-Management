package com.cts.sms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.sms.model.Student;
import com.cts.sms.service.StudentServiceImpl;

@Controller
public class StudentViewController {
	@Autowired
	StudentServiceImpl stu;

	
	@GetMapping(value = "/stuview")
	public String showStudentView(@ModelAttribute("student") Student student,HttpSession session, HttpServletRequest request,Model m) {
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "studentview";
	}
	
	@RequestMapping(value = "/submitstuview")
	public String submitStudentView(@RequestParam("id") int id,@ModelAttribute("student") Student student,Model m) {
		Student s = stu.viewStudentDetails(id);
		
		if (s == null) {

			m.addAttribute("student1", null);
			m.addAttribute("msg", "Record Not Found");
			return "studentview";
		} else {
			m.addAttribute("student1", s);
			
			return "studentview";
		}
	}
	
	@RequestMapping(value="/viewall")
	public String viewAllStudents(Model m,HttpSession session, HttpServletRequest request)
	{
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		List<Student> stulist = stu.viewAllStudents();
		
		if(stulist==null)
		{
			m.addAttribute("stulist",null);
			m.addAttribute("msg","No Records Found");
			return "allstudentview";
		}
		
		else
		{
		m.addAttribute("stulist",stulist);
		return "allstudentview";
		}
	}
}
