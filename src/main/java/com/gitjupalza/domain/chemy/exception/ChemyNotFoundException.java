package com.gitjupalza.domain.chemy.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChemyNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "궁합정보를 찾을 수 없습니다!";
    private final String errorDetails;
}
