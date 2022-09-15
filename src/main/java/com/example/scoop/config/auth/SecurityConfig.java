package com.example.scoop.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import com.example.scoop.domain.Role;

import javax.sql.DataSource;

@RequiredArgsConstructor
@EnableWebSecurity
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Autowired
	private DataSource dataSource;

	   @Bean
	   @Order(SecurityProperties.BASIC_AUTH_ORDER)
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { http
	               .csrf().disable()
	               .headers().frameOptions().disable() 
	               .and()
                   .authorizeRequests()
                   .antMatchers("/member/signupForm",
						   "/css/**",
						   "/img/**",
                           "/js/**").permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                   .anyRequest().authenticated()
	               .and()
				   .formLogin()						// 로그인 폼 처리
				   .loginPage("/member/loginForm")	// 로그인 폼 위치 지정
				   .loginProcessingUrl("/member/login").permitAll()	// 로그인 폼의 action
				   .usernameParameter("email")		// 로그인폼의 아이디
				   .passwordParameter("password");		// 로그인폼의 비밀번호
//				   .and()
//                   .logout()
//                   .logoutUrl("/logout")
//                   .logoutSuccessUrl("/").permitAll()
//	               .and()
//                   .oauth2Login()
//                   .userInfoEndpoint()
//                   .userService(customOAuth2UserService);
		return http.build();
	   }

	//인증을 위한 쿼리
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				/*
//				 * 인증 (로그인) : 유저정보를 DB에서 시큐리티가 자동 검색
//				 * enabled 비활성화 계정인지 아닌지 확인
//				 * *** BUT 도메인 User isEnabled true로 리턴해서 설정 안해도됨
//				 */
//				.usersByUsernameQuery(
//						"select memberid username, memberpw password, enabled " +
//								"from spring5_member " +
//								"where memberid = ?")
//				/*
//				 * 권한 체크
//				 * ROLE_USER or ROLE_ADMIN
//				 */
//				.authoritiesByUsernameQuery(
//						"select memberid username, rolename role_name " +
//								"from spring5_member " +
//								"where memberid = ?");
//	}

	// 단방향 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	   
}
