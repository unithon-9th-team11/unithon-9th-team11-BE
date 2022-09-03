package com.gitjupalza.domain.chemy.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DummyChemyGeneratorImpl implements ChemyScoreResolver {
    @Override
    public Integer resolve(String firstGithubId, String secondGithubId) {
        return new Random().nextInt(1, 1000);
    }
}
