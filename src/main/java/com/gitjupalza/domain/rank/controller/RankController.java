package com.gitjupalza.domain.rank.controller;

import com.gitjupalza.domain.member.service.LoginUserService;
import com.gitjupalza.domain.rank.data.dto.RankingDto;
import com.gitjupalza.domain.rank.data.response.PageableQueryRankingResponse;
import com.gitjupalza.domain.rank.data.response.QueryRankingResponse;
import com.gitjupalza.domain.rank.service.RankService;
import com.gitjupalza.domain.rank.util.RankConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rank")
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;
    private final RankConverter rankConverter;
    private final LoginUserService loginUserService;

    @GetMapping("/list")
    public ResponseEntity<PageableQueryRankingResponse> queryRankings(@RequestParam final Integer size, @RequestParam final Integer page) {
        final PageRequest pageRequest = PageRequest.of(page, size);
        final Page<RankingDto> dtoPage = rankService.queryRankingsWithPagination(pageRequest);
        final Page<QueryRankingResponse> responsePage = dtoPage.map(rankConverter::toResponse);
        final Long issuerIdx = loginUserService.getLoginUserIdx();
        final PageableQueryRankingResponse response = rankConverter.toResponse(responsePage, issuerIdx);
        return ResponseEntity.ok(response);
    }
}
