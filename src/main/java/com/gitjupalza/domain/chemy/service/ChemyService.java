package com.gitjupalza.domain.chemy.service;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;

public interface ChemyService {
    Long createChemy(String firstGithubId, String secondGithubId);
    ChemyDto queryByIdx(Long idx);
    Long deleteChemy(Long idx);
}
