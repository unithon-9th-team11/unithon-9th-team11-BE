package com.gitjupalza.domain.chemy.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateChemyRequest {
    private String firstGithubId;
    private String secondGithubId;
}
