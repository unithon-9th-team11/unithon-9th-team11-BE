package com.gitjupalza.domain.chemy.data.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChemyRequest {
    private String firstGithubId;
    private String secondGithubId;
}
