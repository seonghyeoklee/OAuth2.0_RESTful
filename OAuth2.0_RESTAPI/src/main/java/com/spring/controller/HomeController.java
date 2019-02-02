package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String naver(HttpSession session, Model model) {

		Map<String, String> map = signService.getApiParams();

		session.setAttribute("state", map.get("state"));
		model.addAttribute("apiURL", map.get("apiURL"));

		return "/naverlogin";
	}

	@GetMapping("/redirect")
	public String redirect(@RequestParam("code")String code, @RequestParam("state")String state) {

		signService.getNaverUserInfo(code, state);

		return "/callback";
	}
}
