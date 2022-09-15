package com.example.scoop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
@Table(name="scoop_member")
public class User implements UserDetails {

	@Id
	@Column(nullable = false)
	private String email;				// 회원 아이디 이메일
	
	@Column
	private String password;			// 회원 비밀번호
	
	@Column(nullable = false)
	private String name;				// 회원 이름

	@Column
	private String picture;				// 구글일 경우 프로필 사진
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Column
	private int wsid;					// 워크스페이스 번호 (seq FK)
	
	@Column
	private String udept;				// 부서명
	
	@Builder
	public User(String email, String password, String name, String picture, Role role, int wsid, String udept) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.picture = picture;
		this.role = role;
		this.wsid = wsid;
		this.udept = udept;
	}
	
	public User update(String name, String picture) {
		this.name = name;
		this.picture = picture;
		return this;
	}

	public User update(String name) {
		this.name = name;
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}

	/////// UserDetails 구현 : 현재 로그인한 아이디 비밀번호를 세션에서 받아옴 /////////

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/**
	 * 세션에 로그인한 유저 아이디
	 * @return email 아이디
	 */
	@Override
	public String getUsername() {
		return this.email;
	}

	/**
	 * 세션에 로그인한 유저 비번
	 * @return 비밀번호 (인코딩필요)
	 */
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * enabled
	 * 0 : false 비활성화
	 * 1 : true 활성화
	 * @return true/false
	 */
	@Override
	public boolean isEnabled() {
		return true;							// 아이디 활성화
	}
}

