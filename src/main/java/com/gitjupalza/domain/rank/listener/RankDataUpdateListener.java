package com.gitjupalza.domain.rank.listener;

import com.gitjupalza.domain.chemy.data.event.CreateChemyEvent;
import com.gitjupalza.domain.chemy.data.event.DeleteChemyEvent;
import com.gitjupalza.domain.chemy.data.event.QueryChemyEvent;
import com.gitjupalza.domain.chemy.service.ChemyService;
import com.gitjupalza.domain.rank.data.dto.RankingDto;
import com.gitjupalza.domain.rank.data.entity.Ranking;
import com.gitjupalza.domain.rank.repository.RankingRepository;
import com.gitjupalza.domain.rank.util.RankConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class RankDataUpdateListener {
    private final RankingRepository rankingRepository;
    private final RankConverter rankConverter;
    private final ChemyService chemyService;

    @EventListener(CreateChemyEvent.class)
    public void createRankData(CreateChemyEvent event) {
        AtomicReference<Ranking> atomic = new AtomicReference<>();
        rankingRepository.findByChemyIdxAndViewerIdx(event.getCreatedChemyIdx(), event.getIssuerIdx())
                .ifPresentOrElse(
                        ranking -> {
                            ranking.setChemyIdx(event.getCreatedChemyIdx());
                            ranking.setViewerIdx(event.getIssuerIdx());
                            atomic.set(ranking);
                        }, () -> {
                            RankingDto dto = rankConverter.toDto(event);
                            Ranking entity = rankConverter.toEntity(dto);
                            atomic.set(entity);
                        });
        rankingRepository.save(atomic.get());
    }

    @EventListener(DeleteChemyEvent.class)
    public void deleteRankData(DeleteChemyEvent event) {
        final Long chemyIdx = event.getDeletedChemyIdx();
        rankingRepository.deleteAllByChemyIdx(chemyIdx);
    }

    @EventListener(QueryChemyEvent.class)
    public void updateRankData(QueryChemyEvent event) {
        chemyService.createChemy(event.getFirstGithubId(), event.getSecondGithubId());
    }
}
