package com.gitjupalza.domain.chemy.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PersonalResponse {
    private String githubId;
    private Integer totalStar;
    private Integer totalCommit;
    private Integer totalOrganization;
}
