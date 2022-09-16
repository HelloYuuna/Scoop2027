package com.example.scoop.service;

import com.example.scoop.domain.Member;
import com.example.scoop.domain.MemberDTO;
import com.example.scoop.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean findById(String email) {
        Optional<Member> member = repository.findById(email);
        return member.isPresent();
    }

    @Override
    public Member insertMember(MemberDTO member) {
        // 데이터베이스의 데이터 보호를 위하여 DTO객체로 우회하여 저장
        Member persistentMember = new Member();
        persistentMember.setEmail(member.getEmail());
        
        // 비밀번호 인코딩
        String encodedPW = passwordEncoder.encode(member.getPassword());
        persistentMember.setPassword(encodedPW);

        return repository.save(persistentMember);
    }
}
