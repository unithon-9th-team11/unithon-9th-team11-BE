package com.gitjupalza.domain.chemy.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnknownPersonalGithubDataException extends RuntimeException {
    private static final String ERROR_MESSAGE = "깃허브 개인정보를 찾을 수 없습니다!";
    private final String errorDetails;
}
