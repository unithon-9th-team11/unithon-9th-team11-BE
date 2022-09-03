package com.gitjupalza.domain.chemy.util;

import org.springframework.stereotype.Component;

@Component
public class DummyChemyGeneratorImpl implements ChemyScoreResolver {
    @Override
    public Integer resolve(String firstGithubId, String secondGithubId) {
        return 100;
    }
}
