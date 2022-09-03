package com.gitjupalza.domain.chemy.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersonalResponse {
    private final String githubId;
    private final Integer totalStar;
    private final Integer totalCommit;
    private final Integer totalOrganization;
}
