package com.gitjupalza.domain.member.service;

import com.gitjupalza.domain.member.exception.UserNotFoundException;
import com.gitjupalza.domain.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService{
    private final UserRepository userRepository;

    @Override
    public String getLoginUserId() {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @Override
    public Long getLoginUserIdx() {
        return userRepository.findById(getLoginUserId())
                .orElseThrow(() -> new UserNotFoundException("현재 로그인한 유저의 인덱스를 찾을 수 없습니다!"))
                .getIdx();
    }
}
