package com.gitjupalza.domain.rank.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RankingDto {
    private final Long idx;
    private final Long viewerIdx;
    private final Long chemyIdx;
}
