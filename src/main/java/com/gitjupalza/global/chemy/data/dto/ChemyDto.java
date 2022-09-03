package com.gitjupalza.global.chemy.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChemyDto {
    private final Long id;
    private final String firstGithubId;
    private final String secondGithubId;
    private final Integer chemyScore;
}
