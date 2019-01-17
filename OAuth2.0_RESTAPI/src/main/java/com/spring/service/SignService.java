package com.spring.service;

import com.spring.domain.GoogleUserInfo;

public interface SignService {

	public GoogleUserInfo getGoogleUserInfo(String code);

}
