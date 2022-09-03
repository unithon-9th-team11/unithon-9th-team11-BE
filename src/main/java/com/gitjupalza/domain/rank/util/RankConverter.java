package com.gitjupalza.domain.rank.util;

import com.gitjupalza.domain.rank.data.dto.RankingDto;
import com.gitjupalza.domain.rank.data.response.PageableQueryRankingResponse;
import com.gitjupalza.domain.rank.data.response.QueryRankingResponse;
import org.springframework.data.domain.Page;

public interface RankConverter {
    QueryRankingResponse toResponse(RankingDto dto);
    PageableQueryRankingResponse toResponse(Page<QueryRankingResponse> responsePage, Long issuerIdx);
}
