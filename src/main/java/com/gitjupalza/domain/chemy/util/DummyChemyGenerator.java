package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DummyChemyGenerator implements ChemyGenerator{
    @Override
    public ChemyDto generate(String firstGithubId, String secondGithubId) {
        return new ChemyDto(0L, firstGithubId, secondGithubId, new Random().nextInt(100));
    }
}
