package com.gitjupalza.domain.member.service;

import com.gitjupalza.domain.member.data.dto.SignInDto;
import com.gitjupalza.domain.member.data.dto.SignUpDto;
import com.gitjupalza.domain.member.repository.UserRepository;
import com.gitjupalza.domain.member.filter.JwtTokenProvider;
import com.gitjupalza.domain.member.data.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public Long register(SignUpDto signUpDto) {
        return userRepository.save(Account.builder()
                .id(signUpDto.getId())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getIdx();
    }

    public String login(SignInDto signInDto){
        Account member = userRepository.findById(signInDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디입니다."));
        if (!passwordEncoder.matches(signInDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getId(), "USER");
    }

    public boolean checkIsPossible(String id) {
        return userRepository.existsById(id);
    }
}
