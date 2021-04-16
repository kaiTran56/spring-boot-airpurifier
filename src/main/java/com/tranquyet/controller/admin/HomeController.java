package com.tranquyet.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeAdmin")
@RequestMapping("/admin")
public class HomeController {
	@GetMapping("/start/text")
	public String login() {
		return "admin/index";
	}

	@GetMapping("/home")
	public String home() {
		return "admin/index";
	}

}
