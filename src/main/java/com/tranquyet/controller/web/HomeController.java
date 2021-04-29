package com.tranquyet.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeUser")
public class HomeController {

	@GetMapping("/trang-chu")
	public String getHome() {

		return "web/index";
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/trang-chu";
	}

}
