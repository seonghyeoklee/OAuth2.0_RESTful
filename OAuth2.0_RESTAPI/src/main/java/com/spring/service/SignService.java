package com.spring.service;

import com.spring.model.FacebookUserInfo;
import com.spring.model.GoogleUserInfo;
import com.spring.model.KakaoUserInfo;

public interface SignService {

	public GoogleUserInfo getGoogleUserInfo(String code);

	public FacebookUserInfo getFacebookUserInfo(String accessToken);

	public KakaoUserInfo getKakaoUserInfo(String authorization);

}
