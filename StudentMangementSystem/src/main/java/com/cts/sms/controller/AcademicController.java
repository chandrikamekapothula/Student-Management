package com.cts.sms.controller;

import java.util.List;

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
public class AcademicController {

	@Autowired
	StudentServiceImpl stu;
	
	int id;
	@RequestMapping(value="/acd")
	public String showAcademicPage(HttpSession session, HttpServletRequest request,Model m,@ModelAttribute("student") Student student)
	{
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "academic";
	}
	
	@RequestMapping(value="/submitid")
	public String submitIdAcademicPage(@RequestParam("id") int id ,Model m,@ModelAttribute("student") Student student,RedirectAttributes rm)
	{
		Student s = stu.viewAcademicDetails(id);
		this.id=id;
		//m.addAttribute("stu", s);
		
		if(s==null)
		{
			
			rm.addFlashAttribute("msg","Id not Found");
			return "redirect:/acd";
		}
		
		m.addAttribute("stu", s);
		return "academic";
	}
	
	@RequestMapping(value="/submitacd")
	public String submitAcademicPage(@ModelAttribute("student") Student student,Model m,RedirectAttributes rm)
	{
		int r = stu.addMarks(student, id);
		
if (r == 0) {
			
			rm.addFlashAttribute("msg", "Marks Addedd Unsuccessful");
			return "redirect:/acd";
		} 
			int marks = student.getMarks1()+student.getMarks2()+student.getMarks3();
			String grade = stu.calculateGrade(marks);
			int s = stu.saveGrade(id,grade);
			student.setGrade(grade);
			rm.addFlashAttribute("msg", "Marks Addedd Successful");
			return "redirect:/acd";
			
	}
	
	@RequestMapping(value="/viewac")
	public String viewAcademic(HttpSession session, HttpServletRequest request,Model m,@ModelAttribute("student")Student student)
	{
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		
		return "viewacademic";
	}
	
	@RequestMapping(value="/submitviewac")
	public String submitViewAcademic(@RequestParam("id") int id,@ModelAttribute("student") Student student,Model m)
	{
		Student s = stu.viewAcademicDetails(id);
		//System.out.println(s.getMarks1());
		if (s == null) {

			m.addAttribute("student1", null);
			m.addAttribute("msg", "Record Not Found");
			return "viewacademic";
		} else {
			m.addAttribute("student1", s);
			
			return "viewacademic";
		}
		
	}
	

	@RequestMapping(value="/viewallac")
	public String viewAllStudents(Model m,HttpSession session, HttpServletRequest request)
	{
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			m.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		List<Student> stulist = stu.viewAllAcademicStudents();
		
		if(stulist==null)
		{
			m.addAttribute("stulist",null);
			m.addAttribute("msg","No Records Found");
			return "allacademicview";
		}
		
		else
		{
		m.addAttribute("stulist",stulist);
		
		return "allacademicview";
		}
	}
}
