package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;

public interface ChemyConverter {
    QueryChemyResponse toQueryResponse(ChemyDto dto);
}
