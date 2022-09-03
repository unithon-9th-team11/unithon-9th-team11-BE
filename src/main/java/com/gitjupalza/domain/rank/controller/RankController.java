package com.gitjupalza.domain.rank.controller;

import com.gitjupalza.domain.rank.data.dto.DetailedRankingDto;
import com.gitjupalza.domain.rank.data.response.PageableQueryRankingResponse;
import com.gitjupalza.domain.rank.data.response.QueryRankingResponse;
import com.gitjupalza.domain.rank.service.RankingService;
import com.gitjupalza.domain.rank.util.RankConverter;
import com.gitjupalza.global.member.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rank")
@RequiredArgsConstructor
public class RankController {
    private final RankingService rankingService;
    private final RankConverter rankConverter;
    private final LoginUserService loginUserService;

    @GetMapping("/list")
    public ResponseEntity<PageableQueryRankingResponse> queryRankings(@RequestParam final Integer size, @RequestParam final Integer page) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        final List<DetailedRankingDto> dtoPage = rankingService.queryRankingsWithPagination(pageRequest);
        final List<QueryRankingResponse> responsePage = dtoPage.stream()
                .map(rankConverter::toResponse)
                .collect(Collectors.toList());
        final Long issuerIdx = loginUserService.getLoginUserIdx();
        final PageableQueryRankingResponse response = rankConverter.toResponse(responsePage, issuerIdx);
        return ResponseEntity.ok(response);
    }
}
