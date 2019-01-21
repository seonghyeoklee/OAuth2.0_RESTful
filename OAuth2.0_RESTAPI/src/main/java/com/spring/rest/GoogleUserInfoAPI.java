package com.spring.rest;

import com.spring.model.GoogleUserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GoogleUserInfoAPI {

	String BASE_URL = "https://openidconnect.googleapis.com";

	@GET("/v1/userinfo")
	Call<GoogleUserInfo> userInfo(@Header("Authorization") String authorization);
}
