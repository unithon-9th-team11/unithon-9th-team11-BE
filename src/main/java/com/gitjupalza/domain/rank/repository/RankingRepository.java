package com.gitjupalza.domain.rank.repository;

import com.gitjupalza.domain.rank.data.entity.Ranking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends CrudRepository<Ranking, Long> {
    List<Ranking> findAllByViewerIdx(Long viewerIdx);
    void deleteAllByChemyIdx(Long chemyIdx);
    Optional<Ranking> findByChemyIdxAndViewerIdx(Long chemyIdx, Long viewerIdx);
}
