package com.yaxye.cinemabooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yaxye.cinemabooking.entity.User;
import com.yaxye.cinemabooking.service.UserService;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private final UserService userService;
	
	public RegisterController(UserService userService) {
		this.userService = userService;
	}
	// Show User before creating one.
	
	@GetMapping(value = "register")
	public ModelAndView showUsers() {
		ModelAndView mav = new ModelAndView("Users/register");
		User user = new User();
		mav.addObject("users",user);
		
		return mav;
	
	}
	
	@PostMapping(value = "adduser")

	//@PostMapping("adduser")
	public RedirectView saveUser(@ModelAttribute("users") User user) {
		userService.saveUser(user);
		RedirectView redirectView = new RedirectView("login", true);
		return redirectView;		
		
	}
}
