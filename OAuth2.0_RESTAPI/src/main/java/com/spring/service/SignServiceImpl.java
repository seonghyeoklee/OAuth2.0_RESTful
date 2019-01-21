package com.spring.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.spring.model.FacebookUserInfo;
import com.spring.model.GoogleAuth;
import com.spring.model.GoogleUserInfo;
import com.spring.model.KakaoUserInfo;
import com.spring.rest.FacebookUserInfoAPI;
import com.spring.rest.GoogleOAuthAPI;
import com.spring.rest.GoogleUserInfoAPI;
import com.spring.rest.KakaoUserInfoAPI;

import retrofit2.Response;

@Service
public class SignServiceImpl implements SignService{

	@Autowired
	GoogleOAuthAPI google;

	@Autowired
	GoogleUserInfoAPI googleUserInfoAPI;

	@Autowired
	FacebookUserInfoAPI facebookUserInfoAPI;

	@Autowired
	KakaoUserInfoAPI kakaoUserInfoAPI;

	@Override
	public GoogleUserInfo getGoogleUserInfo(String code) {
		try {
			Response<GoogleAuth> response = google.getToken(GoogleOAuthAPI.TOKEN_STATIC_FILED_MAP, code).execute();

			GoogleUserInfo googleUserInfo = googleUserInfoAPI.userInfo("Bearer " + response.body().getAccessToken()).execute().body();

			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(googleUserInfo));

			return googleUserInfo;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public FacebookUserInfo getFacebookUserInfo(String accessToken) {
		try {
			FacebookUserInfo facebookUserInfo = facebookUserInfoAPI.userInfoByToken(accessToken, "id,name").execute().body();

			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(facebookUserInfo));

			return facebookUserInfo;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public KakaoUserInfo getKakaoUserInfo(String authorization) {
		try {
			KakaoUserInfo kakaoUserInfo = kakaoUserInfoAPI.userInfoByToken("Bearer " + authorization).execute().body();

			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(kakaoUserInfo));

			return kakaoUserInfo;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}