package com.gitjupalza.domain.chemy.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChemyDto {
    private final String firstGithubId;
    private final String secondGithubId;
    private final Integer chemyScore;
}
