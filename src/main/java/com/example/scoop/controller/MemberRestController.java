package com.example.scoop.controller;

import com.example.scoop.domain.Member;
import com.example.scoop.domain.MemberDTO;
import com.example.scoop.repository.MemberRepository;
import com.example.scoop.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/member")
@Slf4j
public class MemberRestController {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberService service;

    /**
     * 아이디 중복체크
     * @param email 회원가입폼에서 받아온 아이디
     * @return boolean 중복아이디가 존재하는지 반환
     */
    @PostMapping("/idcheck")
    public boolean idChk(String email) {
        log.info("email: {}", email);

        return service.findById(email);
    }

    /**
     * 회원가입
     * @param member 회원가입폼에서 넘어온 아이디 비밀번호값
     */
    @PostMapping("/signup")
    public boolean signup(MemberDTO member) {
        log.info("member: {}", member);

        Member newMember = service.insertMember(member);
        log.info("save반환값: {}", newMember);

        return newMember == null;
    }
}
