package com.gitjupalza.domain.rank.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QueryRankingResponse {
    private final String firstGithubIdx;
    private final String secondGithubIdx;
    private final Integer score;
}
