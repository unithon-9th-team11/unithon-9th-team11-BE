package com.gitjupalza.global.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.event.CreateChemyEvent;
import com.gitjupalza.domain.chemy.data.event.DeleteChemyEvent;
import com.gitjupalza.domain.chemy.data.event.QueryChemyEvent;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;
import com.gitjupalza.global.chemy.data.dto.ChemyDto;

public interface ChemyConverter {
    QueryChemyResponse toQueryResponse(ChemyDto dto, PersonalGithubDataDto first, PersonalGithubDataDto second);
    Chemy toEntity(ChemyDto dto);

    ChemyDto toDto(Chemy entity);

    CreateChemyEvent toCreateEvent(Chemy entity, Long issuerIdx);

    DeleteChemyEvent toDeleteEvent(Long idx);

    QueryChemyEvent toQueryEvent(Chemy entity);
}
