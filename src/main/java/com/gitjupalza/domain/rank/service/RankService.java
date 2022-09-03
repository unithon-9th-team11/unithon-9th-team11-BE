package com.gitjupalza.domain.rank.service;

import com.gitjupalza.domain.rank.data.dto.RankingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RankService {
    Page<RankingDto> queryRankingsWithPagination(PageRequest page);
}
