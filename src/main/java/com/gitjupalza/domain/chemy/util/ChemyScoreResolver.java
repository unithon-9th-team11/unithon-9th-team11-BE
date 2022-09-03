package com.gitjupalza.domain.chemy.util;


import java.io.IOException;

public interface ChemyScoreResolver {
    Integer resolve(String firstGithubId, String secondGithubId) throws IOException;
}
