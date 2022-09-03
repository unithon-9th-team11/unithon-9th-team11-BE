package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChemyGeneratorImpl implements ChemyGenerator{
    @Override
    public ChemyDto generate(String firstGithubId, String secondGithubId) {
        return new ChemyDto(0L, firstGithubId, secondGithubId, -1);
    }
}
