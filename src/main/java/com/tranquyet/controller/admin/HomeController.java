package com.tranquyet.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeAdmin")

public class HomeController {
	@GetMapping("/admin/home")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login/login";
	}


}
