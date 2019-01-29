package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.SignService;

@Controller
public class HomeController {

	@Autowired
	private SignService signService;

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

	@GetMapping("/naver")
	public String naver() {

		return "/naverlogin";
	}

	@GetMapping("/")
	public String redirect(@RequestParam("code")String code, @RequestParam("state")String state) {

		signService.getNaverUserInfo(code, state);

		return "/callback";
	}
}
