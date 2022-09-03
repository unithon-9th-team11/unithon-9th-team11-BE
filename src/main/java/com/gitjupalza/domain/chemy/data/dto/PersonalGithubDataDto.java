package com.gitjupalza.domain.chemy.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonalGithubDataDto {
    private final String githubId;
    private final Integer totalStar;
    private final Integer totalCommit;
    private final Integer totalOrganization;
}
