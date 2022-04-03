package com.cts.sms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.sms.model.Student;
import com.cts.sms.service.StudentServiceImpl;

@Controller
public class StudentEditController {

	@Autowired
	StudentServiceImpl stu;

	
	int id;
	
	
	@RequestMapping(value = "/stuedit")
	public String showStudentEdit(@ModelAttribute("student") Student student,HttpSession session, HttpServletRequest request,Model m) {
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "studentedit";
	}
	
	@RequestMapping(value="/submitidedit")
	public String submitStudentIdEdit(@RequestParam("id") int id ,Model m,RedirectAttributes rm) {
		Student s = stu.viewStudentDetails(id);
		this.id=id;
		if(s==null)
		{
			rm.addFlashAttribute("msg","Id not Found");
			return "redirect:/stuedit";
		}
		m.addAttribute("student", s);
		return "studentedit";
	}
	
	@RequestMapping(value = "/submitstuedit")
	public String submitStudentEdit(@ModelAttribute("student") Student student,RedirectAttributes rm) {
		int r = stu.updateStudentDetails(student,id);
		if (r == 0) {
			
			rm.addFlashAttribute("msg", "Edit Unsuccessful");
			return "redirect:/stuedit";
		} else {
			rm.addFlashAttribute("msg", "Edit Successful");
			return "redirect:/stuedit";
		}
	}
}
