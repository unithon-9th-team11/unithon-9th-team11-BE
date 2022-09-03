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
        return null;
    }

    @Override
    public ChemyDto toDto(Chemy entity) {
        return null;
    }
}
