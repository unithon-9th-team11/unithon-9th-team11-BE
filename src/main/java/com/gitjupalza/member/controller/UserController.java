package com.gitjupalza.member.controller;

import com.gitjupalza.member.config.JwtTokenProvider;
import com.gitjupalza.member.data.dto.SignInDto;
import com.gitjupalza.member.data.dto.SignUpDto;
import com.gitjupalza.member.data.entity.Account;
import com.gitjupalza.member.repository.UserRepository;
import com.gitjupalza.member.response.DefaultRes;
import com.gitjupalza.member.response.StatusCode;
import com.gitjupalza.member.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody SignUpDto signUpDto) {
        Long idx = userService.register(signUpDto);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원 가입 완료", idx), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SignInDto signInDto) {
        String token = userService.login(signInDto);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 완료", token), HttpStatus.OK);
    }

    // JWT 인증 요청 테스트
    @GetMapping("/test")
    public ResponseEntity test(@RequestAttribute String userId) {
        return ResponseEntity.ok().body("토큰 인증 완료 및 데이터 불러오기 성공 "+userId+"님");
    }

    // 통합 예외 핸들러
    @ExceptionHandler
    public String exceptionHandler(Exception exception) {
        return exception.getMessage();
    }
}
