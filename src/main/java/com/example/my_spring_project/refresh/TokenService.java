package com.example.my_spring_project.refresh;

import com.example.my_spring_project.config.jwt.TokenProvider;
import com.example.my_spring_project.member.Member;
import com.example.my_spring_project.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final MemberService memberService;

    public String createNewAccessToken(String refreshToken) throws IllegalAccessException {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalAccessException("Unexpected token");
        }
        Long memberId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        Member member = memberService.findById(memberId);
        return tokenProvider.generateToken(member, Duration.ofHours(2));
    }
}
