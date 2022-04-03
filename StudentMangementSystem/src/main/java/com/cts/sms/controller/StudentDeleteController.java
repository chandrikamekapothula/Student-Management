package com.cts.sms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.sms.model.Student;
import com.cts.sms.service.StudentServiceImpl;

@Controller
public class StudentDeleteController {
	@Autowired
	StudentServiceImpl stu;

	@RequestMapping(value = "/studel")
	public String showStudentDelete(@ModelAttribute("student") Student student,HttpSession session, HttpServletRequest request,Model m) {
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "studentdel";
	}
	
	@RequestMapping(value = "/submitstudel")
	public String submitStudentDelete(@ModelAttribute("student") Student student, Model m) {
		int r = stu.deleteStudentDetails(student.getId());
		if (r == 0) {
			Student s = stu.viewStudentDetails(student.getId());
			if(s==null)
			{
				m.addAttribute("msg", "Student Id Doesnot exist");
				return "studentdel";
			}
			else
			{
			m.addAttribute("msg", "Deleted Unsuccessful");

			return "studentdel";
			}
		} else {
			m.addAttribute("msg", "Deleted Successful");
			return "studentdel";
		}

		
	}

}
