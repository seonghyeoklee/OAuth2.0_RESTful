package com.spring.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

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

		String clientId = "t5YCQQXeKLCv_ak9RUKO";
		String redirectURI = "";
		try {
			redirectURI = URLEncoder.encode("http://localhost:8080/redirect", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;

		session.setAttribute("state", state);
		model.addAttribute("apiURL", apiURL);

		return "/naverlogin";
	}

	@GetMapping("/redirect")
	public String redirect(@RequestParam("code")String code, @RequestParam("state")String state) {

		signService.getNaverUserInfo(code, state);

		return "/callback";
	}
}
