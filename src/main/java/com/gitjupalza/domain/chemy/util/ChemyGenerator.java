package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.global.chemy.data.dto.ChemyDto;

public interface ChemyGenerator {
    ChemyDto generate(String firstGithubId, String secondGithubId);
}
