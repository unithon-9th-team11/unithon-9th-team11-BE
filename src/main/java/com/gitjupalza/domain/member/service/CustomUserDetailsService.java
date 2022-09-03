package com.gitjupalza.domain.member.service;


import com.gitjupalza.domain.member.repository.UserRepository;
import com.gitjupalza.domain.member.data.entity.Account;
import com.gitjupalza.domain.member.data.entity.CustomAccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원이 존재하지 않습니다."));

        return new CustomAccountDetails(
                user.getId(),
                user.getPassword(),
                user.getRoles()
        );
    }
}
