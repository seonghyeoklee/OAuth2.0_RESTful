package com.spring.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.spring.rest.FacebookUserInfoAPI;
import com.spring.rest.GoogleOAuthAPI;
import com.spring.rest.GoogleUserInfoAPI;
import com.spring.rest.KakaoUserInfoAPI;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitManager {

	@Bean
	public GoogleOAuthAPI getGoogleOAuthAPI(){
		return getRetrofit(GoogleOAuthAPI.BASE_URL).create(GoogleOAuthAPI.class);
	}

	@Bean
	public GoogleUserInfoAPI getGoogleUserInfo() {
		return getRetrofit(GoogleUserInfoAPI.BASE_URL).create(GoogleUserInfoAPI.class);
	}

	@Bean
	public FacebookUserInfoAPI getFacebookUserInfoAPI() {
		return getRetrofit(FacebookUserInfoAPI.BASE_URL).create(FacebookUserInfoAPI.class);
	}

	@Bean
	public KakaoUserInfoAPI getKakaoUserInfoAPI() {
		return getRetrofit(KakaoUserInfoAPI.BASE_URL).create(KakaoUserInfoAPI.class);
	}

	private Retrofit getRetrofit(String BASE_URL) {
		OkHttpClient client = new OkHttpClient.Builder().build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(new Gson()))
				.client(client)
				.build();

		return retrofit;
	}
}
