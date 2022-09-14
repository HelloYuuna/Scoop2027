package com.example.scoop.config.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import com.example.scoop.domain.Role;

@RequiredArgsConstructor
@EnableWebSecurity
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	   @Bean
	   @Order(SecurityProperties.BASIC_AUTH_ORDER)
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { http
	               .csrf().disable()
	               .headers().frameOptions().disable() 
	               .and()
                   .authorizeRequests()
                   .antMatchers("/css/**",
						   "/img/**",
                           "/js/**").permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                   .anyRequest().authenticated()
	               .and()
				   .formLogin()						//일반적인 폼을 이용한 로그인 처리/실패 방법을 사용
				   .loginPage("/member/loginForm")		//시큐리티에서 제공하는 기본 폼이 아닌 사용자가 만든 폼 사용
				   .loginProcessingUrl("/member/login").permitAll()	//인증 처리를 하는 URL을 설정. 로그인 폼의 action으로 지정
				   .usernameParameter("memberid")		//로그인폼의 아이디 입력란의 name
				   .passwordParameter("memberpw");		//로그인폼의 비밀번호 입력란의 name
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
	   
}
