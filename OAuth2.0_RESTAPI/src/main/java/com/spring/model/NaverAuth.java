package com.spring.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class NaverAuth {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("expires_in")
	private String expiresIn;
}
