package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;

public interface ChemyGenerator {
    ChemyDto generate(String firstGithubId, String secondGithubId);
}
