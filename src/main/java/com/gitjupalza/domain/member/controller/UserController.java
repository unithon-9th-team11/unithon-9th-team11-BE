package com.gitjupalza.domain.member.controller;

import com.gitjupalza.domain.member.data.dto.SignInDto;
import com.gitjupalza.domain.member.data.dto.SignUpDto;
import com.gitjupalza.domain.member.repository.UserRepository;
import com.gitjupalza.domain.member.filter.JwtTokenProvider;
import com.gitjupalza.domain.member.response.DefaultRes;
import com.gitjupalza.domain.member.response.StatusCode;
import com.gitjupalza.domain.member.service.UserService;
import lombok.RequiredArgsConstructor;

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

    // 로그인
    @PostMapping("/api/v1/account/id/{id}/exists")
    public ResponseEntity login(@PathVariable("id") String id) {
        boolean isPossible = userService.checkIsPossible(id);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "사용 ", isPossible), HttpStatus.OK);
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
