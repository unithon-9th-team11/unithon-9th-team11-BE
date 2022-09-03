package com.gitjupalza.domain.chemy.data.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChemyDataGenerateEvent {
    private final Long chemyIdx;
    private final String firstGithubId;
    private final String secondGithubId;
}
