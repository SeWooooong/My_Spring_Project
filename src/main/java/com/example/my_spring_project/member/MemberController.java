package com.example.my_spring_project.member;

import com.example.my_spring_project.member.dto.MemberGetReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/insert")
    public String insertMember(@RequestParam String name){
            return  memberService.createMember(name);
    }

    @GetMapping("/select")
    public List<MemberGetReq> selectMember(){
        return memberService.selectMember();
    }
}
