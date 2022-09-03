package com.gitjupalza.domain.rank.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@RequiredArgsConstructor
public class PageableQueryRankingResponse {
    private final Long viewerIdx;
    private final Page<QueryRankingResponse> data;
}
