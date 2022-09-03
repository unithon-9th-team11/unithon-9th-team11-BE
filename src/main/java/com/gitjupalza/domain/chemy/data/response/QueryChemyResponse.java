package com.gitjupalza.domain.chemy.data.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class QueryChemyResponse {
    private PersonalResponse firstPersonalData;
    private PersonalResponse secondPersonalData;
    private Integer chemyScore;
}
