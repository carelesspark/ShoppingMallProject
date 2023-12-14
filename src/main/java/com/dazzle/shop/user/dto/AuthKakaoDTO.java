package com.dazzle.shop.user.dto;

import lombok.Data;

@Data
public class AuthKakaoDTO {
	private int kakao_num;
	private int user_num;
	private String kakao_email;
	private String refresh_token;
}
