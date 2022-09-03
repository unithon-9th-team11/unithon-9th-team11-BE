package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.event.CreateChemyEvent;
import com.gitjupalza.domain.chemy.data.event.DeleteChemyEvent;
import com.gitjupalza.domain.chemy.data.event.QueryChemyEvent;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;

public interface ChemyConverter {
    QueryChemyResponse toQueryResponse(ChemyDto dto);
    Chemy toEntity(ChemyDto dto);

    ChemyDto toDto(Chemy entity);

    CreateChemyEvent toCreateEvent(Chemy entity, Long issuerIdx);

    DeleteChemyEvent toDeleteEvent(Long idx);

    QueryChemyEvent toQueryEvent(Long idx);
}
