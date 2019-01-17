package com.spring.domain;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoogleAuth {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("token_type")
	private String tokenType;

	private String name;
	private String picture;
	private String email;

	@SerializedName("email_verified")
	private boolean emailVerified;
}
