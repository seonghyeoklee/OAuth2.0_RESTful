package com.spring.rest;

import com.spring.domain.KakaoUserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface KakaoUserInfoAPI {

	String BASE_URL = "https://kapi.kakao.com";

	@GET("/v2/user/me")
	Call<KakaoUserInfo> userInfoByToken(@Header("Authorization") String authorization);
}
