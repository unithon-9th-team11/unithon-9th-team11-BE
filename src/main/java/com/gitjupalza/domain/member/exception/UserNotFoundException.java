package com.gitjupalza.domain.member.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "궁합정보를 찾을 수 없습니다!";
    private final String errorDetails;
}
