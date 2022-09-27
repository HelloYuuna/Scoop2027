package com.example.scoop.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import com.example.scoop.domain.User;
import com.example.scoop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.scoop.config.auth.dto.SessionUser;

/**
 * 일반 폼 회원가입 관리용 도메인
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final HttpSession httpSession;

	@Autowired
	private UserService userService;
	
	@GetMapping({"","/"})
	public String scoophome(Model model, @AuthenticationPrincipal UserDetails loginInfo) {
		
		LocalDate now = LocalDate.now();
		
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		String dayOfWeek = now.getDayOfWeek().toString();
		
		model.addAttribute("month", monthValue);
		model.addAttribute("dayOfMonth", dayOfMonth);
		model.addAttribute("dayOfWeek", dayOfWeek);

		/*
		 * 구글 로그인 정보 받아오기
		 */
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		log.debug("User: {}", user);

		if(user != null) {
			model.addAttribute("userName", user.getName());

		} else {
			/*
			 * 폼 로그인 정보 받아오기
			 */
			String loginId = loginInfo.getUsername();
			User formLoginUser = userService.findById(loginId);
			String userName = formLoginUser.getName();

			log.info("폼로그인정보: {}", userName);

			model.addAttribute("userName",userName);
		}


		return "scoophome";
	}
	
}