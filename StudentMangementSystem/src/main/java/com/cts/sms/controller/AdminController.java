package com.cts.sms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.sms.model.Admin;
import com.cts.sms.service.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String homePage(@ModelAttribute("admin")Admin admin)
	{
		return "home";
	}
	
	@RequestMapping(value="/studetail" , method=RequestMethod.POST)
	public String submitAdminPage(RedirectAttributes rm,@ModelAttribute("admin")Admin admin,Model model,HttpSession session, HttpServletRequest request)
	{
		if(adminService.autheticateAdmin(admin))
		{
			session=request.getSession(true);
			session.setAttribute("email", admin.getEmail());
		session.setAttribute("password", admin.getPassword());
			return "details";
		}
		else
		{
			rm.addFlashAttribute("msg","Invalid Admin Credentials!!!");
			return "redirect:/admin";
		}
	}
	
	@RequestMapping("/studetail")
	public String invalidAdmin(HttpSession session, HttpServletRequest request, Model model, RedirectAttributes rm)
	{
		session=request.getSession(false);
		if(session.getAttribute("email")==null && session.getAttribute("password")==null)
		{
			model.addAttribute("msg", "Unauthorised User!!!");
		return "error";
		}
		return "details";
	}
	
	  @GetMapping("/stuinfo")
	  public String stuinfoPage(HttpSession session, HttpServletRequest request, Model model) 
	  {
		  session=request.getSession(false);
			if(session.getAttribute("email")==null && session.getAttribute("password")==null)
			{
				model.addAttribute("msg", "Unauthorised User!!!");
			return "error";
			}
		  return "studentinfo"; 
		  }
	
}
