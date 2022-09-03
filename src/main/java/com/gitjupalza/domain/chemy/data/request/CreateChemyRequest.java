package com.gitjupalza.domain.chemy.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateChemyRequest {
    private final String firstGithubId;
    private final String secondGithubId;
}
