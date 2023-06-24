package com.example.my_spring_project.refresh;

import com.example.my_spring_project.refresh.dto.CreatedAccessTokenRequest;
import com.example.my_spring_project.refresh.dto.CreatedAccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    public final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreatedAccessTokenResponse> createNewAccessToken(@RequestBody CreatedAccessTokenRequest request) throws IllegalAccessException {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreatedAccessTokenResponse(newAccessToken));
    }
}
