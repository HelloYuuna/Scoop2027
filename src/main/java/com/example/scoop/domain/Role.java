package com.example.scoop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	GUEST("ROLE_GUEST", "손님"),
	USER("ROLE_USER", "멤버");
	
	private final String key;
	private final String title;
}
