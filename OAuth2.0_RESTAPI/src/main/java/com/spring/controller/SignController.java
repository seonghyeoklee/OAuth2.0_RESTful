package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.FacebookUserInfo;
import com.spring.domain.GoogleUserInfo;
import com.spring.service.SignService;

@RestController
@RequestMapping("/sign")
public class SignController {

	@Autowired
	SignService signService;

	@PostMapping("/googleAuth")
	public ResponseEntity<GoogleUserInfo> googleAuthorization(String code) {

		GoogleUserInfo googleUserInfo = signService.getGoogleUserInfo(code);

		if(googleUserInfo == null)
			throw new NullPointerException();

		return new ResponseEntity<GoogleUserInfo>(googleUserInfo, HttpStatus.OK);
	}

	@PostMapping("/facebook")
	public ResponseEntity<FacebookUserInfo> facebookAuthorization(String accessToken) {

		FacebookUserInfo facebookUserInfo = signService.getFacebookUserInfo(accessToken);

		if(facebookUserInfo == null)
			throw new NullPointerException();

		return new ResponseEntity<FacebookUserInfo>(facebookUserInfo, HttpStatus.OK);
	}

}
