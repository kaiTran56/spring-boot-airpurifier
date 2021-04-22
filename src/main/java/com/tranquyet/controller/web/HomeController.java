package com.tranquyet.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeUser")
@RequestMapping("/trang-chu")
public class HomeController {

	@GetMapping("/")
	public String getHome() {

		return "web/home";
	}

}
