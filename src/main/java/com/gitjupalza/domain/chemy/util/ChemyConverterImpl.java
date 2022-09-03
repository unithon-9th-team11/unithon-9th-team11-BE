package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;
import org.springframework.stereotype.Component;

@Component
public class ChemyConverterImpl implements ChemyConverter {
    @Override
    public QueryChemyResponse toQueryResponse(ChemyDto dto) {
        return new QueryChemyResponse();
    }

    @Override
    public Chemy toEntity(ChemyDto dto) {
        return new Chemy(0L, dto.getFirstGithubId(), dto.getSecondGithubId(), dto.getChemyScore());
    }

    @Override
    public ChemyDto toDto(Chemy entity) {
        return new ChemyDto(entity.getIdx(), entity.getFirstGithubId(), entity.getSecondGithubId(), entity.getChemyScore());
    }
}
