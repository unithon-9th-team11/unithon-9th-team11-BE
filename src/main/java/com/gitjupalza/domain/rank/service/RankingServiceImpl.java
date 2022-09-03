package com.gitjupalza.domain.rank.service;

import com.gitjupalza.domain.rank.data.dto.DetailedRankingDto;
import com.gitjupalza.domain.rank.data.entity.Ranking;
import com.gitjupalza.domain.rank.repository.RankingRepository;
import com.gitjupalza.domain.rank.util.RankConverter;
import com.gitjupalza.global.member.service.LoginUserService;
import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import com.gitjupalza.global.chemy.repository.ChemyRepository;
import com.gitjupalza.global.chemy.util.ChemyConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankRepository;
    private final RankConverter rankConverter;
    private final LoginUserService loginUserService;
    private final ChemyRepository chemyRepository;
    private final ChemyConverter chemyConverter;

    @Override
    public List<DetailedRankingDto> queryRankingsWithPagination(PageRequest page) {
        final Long viewerIdx = loginUserService.getLoginUserIdx();
        final List<Long> chemyIdxList = rankRepository
                .findAllByViewerIdx(viewerIdx)
                .stream()
                .map(Ranking::getChemyIdx)
                .collect(Collectors.toList());
        final List<ChemyDto> chemyList = chemyRepository
                .findAllById(chemyIdxList)
                .stream()
                .map(chemyConverter::toDto)
                .collect(Collectors.toList());
        return chemyList.stream().sorted(Comparator.comparing(ChemyDto::getChemyScore).reversed())
                .skip(page.getOffset()).limit(page.getPageSize())
                .map(dto -> rankConverter.toDetailedDto(viewerIdx, dto))
                .collect(Collectors.toList());
    }
}
