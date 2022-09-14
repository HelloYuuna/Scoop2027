package com.example.scoop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName     :Scoop
 * fileName        :MemberController
 * author          :yuuna
 * since           :2022/09/14
 */

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("loginForm")
    public String gotoLogin() {
        return "/loginView/loginForm";
    }

}
