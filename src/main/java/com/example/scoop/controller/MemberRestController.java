package com.example.scoop.controller;

import com.example.scoop.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/member")
@Slf4j
public class MemberRestController {

    @Autowired
    private MemberRepository repository;

//    @PostMapping("/idcheck")
//    public boolean idChk(String email) {
//        System.out.println(email);
////        log.info("email: {}", email);
//
//        Optional<Member> member = repository.findById(email);
//
//        return member.isPresent();
//    }
}
