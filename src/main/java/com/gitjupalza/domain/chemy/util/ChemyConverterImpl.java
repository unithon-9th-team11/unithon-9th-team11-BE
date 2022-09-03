package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;
import org.springframework.stereotype.Component;

@Component
public class ChemyConverterImpl implements ChemyConverter {
    @Override
    public QueryChemyResponse toQueryResponse(ChemyDto dto) {
        return new QueryChemyResponse();
    }
}
