package com.gitjupalza.domain.rank.service;

import com.gitjupalza.domain.rank.data.dto.DetailedRankingDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RankingService {
    List<DetailedRankingDto> queryRankingsWithPagination(PageRequest page);
}
