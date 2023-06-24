package com.example.my_spring_project.member;

import com.example.my_spring_project.member.dto.MemberRequestDto.AddMemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Long save(AddMemberRequestDto dto){
        return memberRepository.save(Member.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public Member findById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
