package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/google")
	public String google() {

		return "/google";
	}

	@GetMapping("/facebook")
	public String facebook() {

		return "/facebook";
	}

	@GetMapping("/kakao")
	public String kakao() {

		return "/kakao";
	}
}
