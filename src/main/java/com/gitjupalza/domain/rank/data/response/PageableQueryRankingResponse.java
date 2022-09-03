package com.gitjupalza.domain.rank.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PageableQueryRankingResponse {
    private final Long viewerIdx;
    private final List<QueryRankingResponse> data;
}
