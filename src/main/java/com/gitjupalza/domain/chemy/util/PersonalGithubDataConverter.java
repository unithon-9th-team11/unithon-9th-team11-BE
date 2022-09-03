package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;
import com.gitjupalza.domain.chemy.data.entity.PersonalGithubData;
import com.gitjupalza.domain.chemy.data.response.PersonalResponse;

public interface PersonalGithubDataConverter {
    PersonalGithubDataDto toDto(PersonalGithubData entity);
    PersonalResponse toResponse(PersonalGithubDataDto data);
}
