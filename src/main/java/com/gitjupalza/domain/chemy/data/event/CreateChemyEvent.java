package com.gitjupalza.domain.chemy.data.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateChemyEvent {
    private final Long issuerIdx;
    private final Long createdChemyIdx;
    private final String firstGithubId;
    private final String secondGithubId;
    private final Integer chemyScore;
}
