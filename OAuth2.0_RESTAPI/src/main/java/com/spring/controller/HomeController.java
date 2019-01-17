package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/google")
	public String google() {

		return "/google";
	}

	@RequestMapping("/facebook")
	public String facebook() {

		return "/facebook";
	}
}
