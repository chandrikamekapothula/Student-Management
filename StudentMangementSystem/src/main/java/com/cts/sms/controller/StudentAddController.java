package com.cts.sms.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.sms.model.Student;
import com.cts.sms.service.StudentServiceImpl;

@Controller
public class StudentAddController {

	@Autowired
	StudentServiceImpl stu;

	
	@RequestMapping(value = "/stuadd",method=RequestMethod.GET)
	public String showStudentAdd(@ModelAttribute("student") Student student,HttpSession session, HttpServletRequest request,Model m) {
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "studentadd";
	}

	@RequestMapping(value = "/submitstuadd",method=RequestMethod.POST)
	public String submitStudentAdd(@ModelAttribute("student") Student student, Model m,RedirectAttributes rm)
			throws ParseException {
				
		Student s=stu.viewStudentDetails(student.getId());
		if(s!=null)
		{
			m.addAttribute("msg","Id Already Existed");
			return "studentadd";
		}

		int r = stu.addStudentDetails(student);

		if (r == 0) {
			rm.addFlashAttribute("msg", "Inserted Unsuccessful");
			return "redirect:/stuadd";
		} else {
			rm.addFlashAttribute("msg", "Inserted successful");
			return "redirect:/stuadd";
		}

		

	}

	
	

	

	
	

	
}
