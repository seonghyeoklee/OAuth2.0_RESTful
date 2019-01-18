package com.spring.service;

import com.spring.domain.FacebookUserInfo;
import com.spring.domain.GoogleUserInfo;
import com.spring.domain.KakaoUserInfo;

public interface SignService {

	public GoogleUserInfo getGoogleUserInfo(String code);

	public FacebookUserInfo getFacebookUserInfo(String accessToken);

	public KakaoUserInfo getKakaoUserInfo(String authorization);

}
