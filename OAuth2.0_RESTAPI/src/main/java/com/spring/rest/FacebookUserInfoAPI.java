package com.spring.rest;

import com.spring.domain.FacebookUserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FacebookUserInfoAPI {

	String BASE_URL = "https://graph.facebook.com/v3.2/";

	@POST("me")
	@FormUrlEncoded
	Call<FacebookUserInfo> userInfoByToken(@Field("access_token") String accessToken, @Field("fields") String fields);

}
