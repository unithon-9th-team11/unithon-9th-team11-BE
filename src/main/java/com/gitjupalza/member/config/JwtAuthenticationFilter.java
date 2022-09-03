package com.gitjupalza.member.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = resolveToken(request.getHeader("Authorization"));
        System.out.println("======" + token);
        if (token != null) {
            Authentication authentication = jwtTokenProvider.validateToken(request, token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.setAttribute("userId", jwtTokenProvider.getUserId(token));

        }
        filterChain.doFilter(request, response);
    }

    private String resolveToken(String authorization) {
        return authorization != null ? authorization.substring(7) : null;
    }
}
