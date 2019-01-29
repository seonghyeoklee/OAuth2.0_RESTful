package com.spring.model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaverUserInfo {

	private String message;
	private response response;

	@Data
	public class response {
		private String id;
		@SerializedName("profile_image")
		private String profileImage;
		private String gender;
		private String email;
		private String name;
		private String birthday;
	}
}
