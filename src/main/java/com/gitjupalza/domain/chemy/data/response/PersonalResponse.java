package com.gitjupalza.domain.chemy.data.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalResponse {
    private String githubId;
    private Integer totalStar;
    private Integer totalCommit;
    private Integer totalOrganization;
}
