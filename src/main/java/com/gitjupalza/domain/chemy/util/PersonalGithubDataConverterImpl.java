package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;
import com.gitjupalza.domain.chemy.data.entity.PersonalGithubData;
import com.gitjupalza.domain.chemy.data.response.PersonalResponse;
import org.springframework.stereotype.Component;

@Component
public class PersonalGithubDataConverterImpl implements PersonalGithubDataConverter{
    @Override
    public PersonalGithubDataDto toDto(PersonalGithubData entity) {
        return new PersonalGithubDataDto(entity.getGithubId(), entity.getTotalStar(), entity.getTotalCommit(), entity.getTotalOrganization());
    }

    @Override
    public PersonalResponse toResponse(PersonalGithubDataDto data) {
        return new PersonalResponse(data.getGithubId(), data.getTotalStar(), data.getTotalCommit(), data.getTotalOrganization());
    }
}
