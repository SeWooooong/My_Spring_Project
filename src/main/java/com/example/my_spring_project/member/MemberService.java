package com.example.my_spring_project.member;

import com.example.my_spring_project.member.dto.MemberGetReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String createMember(String name){
        Member member = new Member();
        member.createMember(name);
        memberRepository.save(member);
        return "Member추가 완료";
    }

    public List<MemberGetReq> selectMember(){
        List<Member> members = memberRepository.findAll();
        List<MemberGetReq> results = members.stream()
                .map(member -> new MemberGetReq(member.getId(), member.getName()))
                .toList();
        return results;
    }

}
