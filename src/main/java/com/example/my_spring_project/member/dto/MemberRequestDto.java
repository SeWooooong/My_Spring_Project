package com.example.my_spring_project.member.dto;

import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {

    @Getter
    @Setter
    public static class AddMemberRequestDto {
        private String email;
        private String password;
    }
}
