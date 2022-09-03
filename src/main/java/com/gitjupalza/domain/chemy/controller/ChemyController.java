package com.gitjupalza.domain.chemy.controller;

import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.request.CreateChemyRequest;
import com.gitjupalza.domain.chemy.data.response.CreateChemyResponse;
import com.gitjupalza.domain.chemy.data.response.DeleteChemyResponse;
import com.gitjupalza.domain.chemy.data.response.QueryChemyResponse;
import com.gitjupalza.domain.chemy.service.ChemyService;
import com.gitjupalza.global.chemy.util.ChemyConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chemy")
@RequiredArgsConstructor
public class ChemyController {
    private final ChemyService chemyService;
    private final ChemyConverter chemyConverter;

    //궁합 생성
    @PostMapping
    public ResponseEntity<CreateChemyResponse> createChemy(@RequestBody final CreateChemyRequest request) {
        final Long idx = chemyService.createChemy(request.getFirstGithubId(), request.getSecondGithubId());
        final CreateChemyResponse response = new CreateChemyResponse(idx);
        return ResponseEntity.ok(response);
    }

    //궁합 조회
    @GetMapping("/{idx}")
    public ResponseEntity<QueryChemyResponse> queryChemyByIdx(@PathVariable Long idx) {
        final ChemyDto dto = chemyService.queryByIdx(idx);
        final QueryChemyResponse response = chemyConverter.toQueryResponse(dto);
        return ResponseEntity.ok(response);
    }

    //궁합 삭제
    @DeleteMapping("/{idx}")
    public ResponseEntity<DeleteChemyResponse> deleteChemy(@PathVariable Long idx) {
        final Long deletedChemyIdx = chemyService.deleteChemy(idx);
        final DeleteChemyResponse response = new DeleteChemyResponse(deletedChemyIdx);
        return ResponseEntity.ok(response);
    }
}
