package com.gitjupalza.member.service;


import com.gitjupalza.member.data.entity.Account;
import com.gitjupalza.member.data.entity.CustomAccountDetails;
import com.gitjupalza.member.repository.UserRepository;
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
