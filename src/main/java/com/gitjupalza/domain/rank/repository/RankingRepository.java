package com.gitjupalza.domain.rank.repository;

import com.gitjupalza.domain.rank.data.entity.Ranking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RankingRepository extends CrudRepository<Ranking, Long> {
    List<Ranking> findAllByViewerIdx(Long viewerIdx);
}
