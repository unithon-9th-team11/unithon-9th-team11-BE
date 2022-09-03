package com.gitjupalza.domain.chemy.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QueryChemyResponse {
    private final PersonalResponse firstPersonalData;
    private final PersonalResponse secondPersonalData;
    private final Integer chemyScore;
}
