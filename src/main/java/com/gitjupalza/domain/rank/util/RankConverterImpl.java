package com.gitjupalza.domain.rank.util;

import com.gitjupalza.domain.rank.data.dto.DetailedRankingDto;
import com.gitjupalza.domain.rank.data.response.PageableQueryRankingResponse;
import com.gitjupalza.domain.rank.data.response.QueryRankingResponse;
import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankConverterImpl implements RankConverter{
    @Override
    public QueryRankingResponse toResponse(DetailedRankingDto dto) {
        return new QueryRankingResponse(dto.getFirstGithubId(), dto.getSecondGithubId(), dto.getChemyScore());
    }

    @Override
    public PageableQueryRankingResponse toResponse(List<QueryRankingResponse> responsePage, Long issuerIdx) {
        return new PageableQueryRankingResponse(issuerIdx, responsePage);
    }

    @Override
    public DetailedRankingDto toDetailedDto(Long viewerIdx, ChemyDto dto) {
        return new DetailedRankingDto(viewerIdx, dto.getId(), dto.getFirstGithubId(), dto.getSecondGithubId(), dto.getChemyScore());
    }
}
