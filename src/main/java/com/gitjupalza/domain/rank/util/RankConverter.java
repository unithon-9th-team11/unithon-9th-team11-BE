package com.gitjupalza.domain.rank.util;

import com.gitjupalza.domain.rank.data.dto.DetailedRankingDto;
import com.gitjupalza.domain.rank.data.response.PageableQueryRankingResponse;
import com.gitjupalza.domain.rank.data.response.QueryRankingResponse;
import com.gitjupalza.global.chemy.data.dto.ChemyDto;

import java.util.List;

public interface RankConverter {
    QueryRankingResponse toResponse(DetailedRankingDto dto);
    PageableQueryRankingResponse toResponse(List<QueryRankingResponse> responsePage, Long issuerIdx);
    DetailedRankingDto toDetailedDto(Long viewerIdx, ChemyDto dto);
}
