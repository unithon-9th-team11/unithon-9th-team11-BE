package com.gitjupalza.domain.rank.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PageableQueryRankingResponse {
    private Long viewerIdx;
    private List<QueryRankingResponse> data;
}
