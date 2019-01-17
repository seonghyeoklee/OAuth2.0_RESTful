package com.spring.service;

import com.spring.domain.FacebookUserInfo;
import com.spring.domain.GoogleUserInfo;

public interface SignService {

	public GoogleUserInfo getGoogleUserInfo(String code);

	public FacebookUserInfo getFacebookUserInfo(String accessToken);

}
