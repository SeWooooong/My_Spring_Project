package com.example.my_spring_project.refresh.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatedAccessTokenRequest {
    private String refreshToken;
}
