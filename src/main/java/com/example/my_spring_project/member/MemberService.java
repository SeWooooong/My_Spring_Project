package com.example.my_spring_project.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String createMember(String address){
        Member member = new Member();
        member.createMember(address);
        memberRepository.save(member);
        return "Member추가 완료";
    }

}
