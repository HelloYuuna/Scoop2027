package com.example.scoop.service;

import com.example.scoop.domain.Member;
import com.example.scoop.domain.MemberDTO;

public interface MemberService {

    boolean findById(String email);

    Member insertMember(MemberDTO member);
}
