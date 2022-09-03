package com.gitjupalza.domain.chemy.data.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryChemyResponse {
    private PersonalResponse firstPersonalData;
    private PersonalResponse secondPersonalData;
    private Integer chemyScore;
}
