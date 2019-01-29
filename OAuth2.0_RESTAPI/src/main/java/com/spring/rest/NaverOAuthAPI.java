package com.spring.rest;

import com.spring.model.NaverAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NaverOAuthAPI {

	String BASE_URL = "https://nid.naver.com";

	String grantType = "authorization_code";
	String clientId = "t5YCQQXeKLCv_ak9RUKO";
	String clientSecret = "";
	String redirectUri = "http://localhost:8080/";

	@FormUrlEncoded
	@POST("/oauth2.0/token")
	Call<NaverAuth> getAccessTokenByCode(
			@Field("grant_type") String grantType,
			@Field("client_id") String clientId,
			@Field("client_secret") String clientSecret,
			@Field("redirect_uri") String redirectUri,
			@Field("code") String code,
			@Field("state") String state);
}
