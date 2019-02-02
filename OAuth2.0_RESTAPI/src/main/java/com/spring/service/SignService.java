package com.spring.service;

import java.util.Map;

import com.spring.model.FacebookUserInfo;
import com.spring.model.GoogleUserInfo;
import com.spring.model.KakaoUserInfo;
import com.spring.model.NaverUserInfo;

public interface SignService {

	public GoogleUserInfo getGoogleUserInfo(String code);

	public FacebookUserInfo getFacebookUserInfo(String accessToken);

	public KakaoUserInfo getKakaoUserInfo(String authorization);

	public NaverUserInfo getNaverUserInfo(String code, String state);

	public Map<String, String> getApiParams();
}
