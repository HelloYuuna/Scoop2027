package com.example.scoop.controller;

import com.example.scoop.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/member")
@ResponseBody
public class MemberRestController {

    @PostMapping("/idChk")
    public void idChk(Member member) {
        log.debug("까꿍");
        log.debug("ajax에서 넘어온 Form값: {}", member);
    }
}
