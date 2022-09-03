package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;

public interface ChemyConverter {
    QueryChemyResponse toQueryResponse(ChemyDto dto);
    Chemy toEntity(ChemyDto dto);

    ChemyDto toDto(Chemy entity);
}
