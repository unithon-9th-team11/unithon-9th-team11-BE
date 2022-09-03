package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.event.CreateChemyEvent;
import com.gitjupalza.domain.chemy.data.event.DeleteChemyEvent;
import com.gitjupalza.domain.chemy.data.event.QueryChemyEvent;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;
import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import com.gitjupalza.global.chemy.util.ChemyConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChemyConverterImpl implements ChemyConverter {
    private final PersonalGithubDataConverter personalGithubDataConverter;

    @Override
    public QueryChemyResponse toQueryResponse(ChemyDto dto, PersonalGithubDataDto first, PersonalGithubDataDto second) {
        return new QueryChemyResponse(personalGithubDataConverter.toResponse(first), personalGithubDataConverter.toResponse(second), dto.getChemyScore());
    }

    @Override
    public Chemy toEntity(ChemyDto dto) {
        return new Chemy(0L, dto.getFirstGithubId(), dto.getSecondGithubId(), dto.getChemyScore());
    }

    @Override
    public ChemyDto toDto(Chemy entity) {
        return new ChemyDto(entity.getIdx(), entity.getFirstGithubId(), entity.getSecondGithubId(), entity.getChemyScore());
    }

    @Override
    public CreateChemyEvent toCreateEvent(Chemy entity, Long issuerIdx) {
        return new CreateChemyEvent(issuerIdx, entity.getIdx(), entity.getFirstGithubId(), entity.getSecondGithubId(), entity.getChemyScore());
    }

    @Override
    public DeleteChemyEvent toDeleteEvent(Long idx) {
        return new DeleteChemyEvent(idx);
    }

    @Override
    public QueryChemyEvent toQueryEvent(Chemy entity) {
        return new QueryChemyEvent(entity.getIdx(), entity.getFirstGithubId(), entity.getSecondGithubId(), entity.getChemyScore());
    }
}
