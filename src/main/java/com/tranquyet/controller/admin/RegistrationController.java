package com.tranquyet.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranquyet.dto.UserDTO;
import com.tranquyet.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public UserDTO userDTO() {
		return new UserDTO();
	}

	@GetMapping
	public String showRegistration() {
		return "registration/registration";
	}
	@GetMapping("/test")
	public String show() {
		return "sec";
	}

	@PostMapping
	public String resgistrationUserAccount(@ModelAttribute("user") UserDTO userDTO) {
		userService.save(userDTO);
		return "redirect:/registration?success";
	}

}
