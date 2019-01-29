package com.spring.rest;

import com.spring.model.NaverUserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface NaverUserInfoAPI {

	String BASE_URL = "https://openapi.naver.com";

	@GET("/v1/nid/me")
	Call<NaverUserInfo> userInfoByToken(@Header("Authorization") String authorization);

}
