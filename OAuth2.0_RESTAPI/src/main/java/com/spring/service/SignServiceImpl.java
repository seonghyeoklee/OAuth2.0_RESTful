package com.spring.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.spring.model.FacebookUserInfo;
import com.spring.model.GoogleAuth;
import com.spring.model.GoogleUserInfo;
import com.spring.model.KakaoUserInfo;
import com.spring.model.NaverAuth;
import com.spring.model.NaverUserInfo;
import com.spring.rest.FacebookUserInfoAPI;
import com.spring.rest.GoogleOAuthAPI;
import com.spring.rest.GoogleUserInfoAPI;
import com.spring.rest.KakaoUserInfoAPI;
import com.spring.rest.NaverOAuthAPI;
import com.spring.rest.NaverUserInfoAPI;

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

	@Autowired
	NaverUserInfoAPI naverUserInfoAPI;

	@Autowired
	NaverOAuthAPI naverOAuthAPI;

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

	@Override
	public NaverUserInfo getNaverUserInfo(String code, String state) {
		try {
			NaverAuth naverAuth = naverOAuthAPI.getAccessTokenByCode(
					naverOAuthAPI.grantType,
					naverOAuthAPI.clientId,
					naverOAuthAPI.clientSecret,
					naverOAuthAPI.redirectUri,
					code,
					state).execute().body();

			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(naverAuth));

			String accessToken = naverAuth.getTokenType() + " " + naverAuth.getAccessToken();

			NaverUserInfo naverUserInfo = naverUserInfoAPI.userInfoByToken(accessToken).execute().body();

			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(naverUserInfo));

			return naverUserInfo;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Map<String, String> getApiParams() {

		String redirectURI = "";

		try {
			redirectURI = URLEncoder.encode(NaverOAuthAPI.redirectUri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();

		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + NaverOAuthAPI.clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;

		Map<String, String> map = new HashMap<>();
		map.put("state", state);
		map.put("apiURL", apiURL);

		return map;
	}
}