package com.spring.rest;

import java.util.HashMap;
import java.util.Map;

import com.spring.domain.GoogleAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GoogleOAuthAPI {

	String BASE_URL = "https://www.googleapis.com";

	String client_id = "788806329174-6aufaqsdku9p51avh129kkusgk9i1v0t.apps.googleusercontent.com";
	String client_secret = "IgAW6i_mux3wtaJC4r1Hc-WC";
	String redirect_uri = "http://localhost:8080";
	String grant_type = "authorization_code";

	Map<String, String> TOKEN_STATIC_FILED_MAP = new HashMap<String, String>() {{
		put("client_id", client_id);
		put("client_secret", client_secret);
		put("redirect_uri", redirect_uri);
		put("grant_type", grant_type);
	}};

	@POST("/oauth2/v4/token")
	@FormUrlEncoded
	Call<GoogleAuth> getToken(@FieldMap Map<String, String> staticFieldMap, @Field("code") String code);

}
