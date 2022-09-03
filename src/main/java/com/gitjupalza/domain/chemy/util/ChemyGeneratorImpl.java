package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ChemyGeneratorImpl implements ChemyGenerator{
    private final ChemyScoreResolver chemyScoreResolver;
    @Override
    public ChemyDto generate(String firstGithubId, String secondGithubId) {
        Integer score = null;
        try {
            score = chemyScoreResolver.resolve(firstGithubId, secondGithubId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ChemyDto(0L, firstGithubId, secondGithubId, score);
    }
}
