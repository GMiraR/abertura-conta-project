package com.gui.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;

	@RequestMapping("/home")
	@ResponseBody
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")	
	public String viewRegisterForm(Model model) {
		model.addAttribute("user", new User());
		
		return "register";
	}
	
  	
	@PostMapping("/process_register")
	public String processRegistration(User user){	
		PasswordEncoder enc = new PasswordEncoder();
		user.setPassword(enc.encodePass(user.getPassword()));
		
		repo.save(user);
		
		
		return "successful_register";
	}
	
	@GetMapping("/more_info")
	public String viewMoreInfo() {
		return "more_info";
	}

}
