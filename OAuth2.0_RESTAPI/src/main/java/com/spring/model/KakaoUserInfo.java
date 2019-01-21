package com.spring.model;

import lombok.Data;

@Data
public class KakaoUserInfo {

	private long id;
	private properties properties;
	private kakao_account kakao_account;

	@Data
	public class properties {
		private String nickname;
		private String profile_image;
		private String thumbnail_image;
	}

	@Data
	public class kakao_account{
		private String email;
	}
}
