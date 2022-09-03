package com.gitjupalza.domain.rank.data.response;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageableQueryRankingResponse {
    private Long viewerIdx;
    private List<QueryRankingResponse> data;
}
