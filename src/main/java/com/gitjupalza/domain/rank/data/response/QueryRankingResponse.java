package com.gitjupalza.domain.rank.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class QueryRankingResponse {
    private String firstGithubIdx;
    private String secondGithubIdx;
    private Integer score;
}
