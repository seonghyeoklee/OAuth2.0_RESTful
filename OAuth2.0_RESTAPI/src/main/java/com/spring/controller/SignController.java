package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.GoogleUserInfo;
import com.spring.service.SignService;

@RestController
@RequestMapping("/sign")
public class SignController {

	@Autowired
	SignService googleService;

	@PostMapping("/googleAuth")
	public ResponseEntity<GoogleUserInfo> googleAuthorization(String code) {
		System.out.println(code);

		GoogleUserInfo googleUserInfo = googleService.getGoogleUserInfo(code);

		if(googleUserInfo == null)
			throw new NullPointerException();

		return new ResponseEntity<GoogleUserInfo>(googleUserInfo, HttpStatus.OK);
	}

}
