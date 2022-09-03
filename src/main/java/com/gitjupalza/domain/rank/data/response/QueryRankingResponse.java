package com.gitjupalza.domain.rank.data.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryRankingResponse {
    private String firstGithubIdx;
    private String secondGithubIdx;
    private Integer score;
}
