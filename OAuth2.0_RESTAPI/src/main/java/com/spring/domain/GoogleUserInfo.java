package com.spring.domain;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoogleUserInfo {

	private String sub;
	private String name;
	private String picture;
	private String profile;
	private String email;

	@SerializedName("email_verified")
	private boolean emailVerified;

	private String gender;
	private String locale;
}
