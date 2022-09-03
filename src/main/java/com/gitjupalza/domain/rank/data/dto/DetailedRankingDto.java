package com.gitjupalza.domain.rank.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DetailedRankingDto {
    private final Long viewerIdx;
    private final Long chemyIdx;
    private final String firstGithubId;
    private final String secondGithubId;
    private final Integer chemyScore;
}
