package com.example.scoop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="SCOOP_USER")
public class User {

	@Id
	@Column(nullable = false)
	private String email;				// 회원 아이디 이메일

	@Column(nullable = false)
	private String name;				// 회원 이름
	
//	@Column
//	private String picture;				// 구글일 경우 프로필 사진
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Builder
	public User(String name, String email, String picture, Role role) {
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}
	
	public User update(String name, String picture) {
		this.name = name;
		this.picture = picture;
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}

