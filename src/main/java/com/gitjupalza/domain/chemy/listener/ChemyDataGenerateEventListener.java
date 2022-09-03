package com.gitjupalza.domain.chemy.listener;

import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.event.ChemyDataGenerateEvent;
import com.gitjupalza.domain.chemy.util.ChemyScoreResolver;
import com.gitjupalza.global.chemy.repository.ChemyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ChemyDataGenerateEventListener {
    private final ChemyScoreResolver chemyScoreResolver;
    private final ChemyRepository chemyRepository;

    @EventListener(ChemyDataGenerateEvent.class)
    public void handleEvent(ChemyDataGenerateEvent event) {
        Integer score = null;
        try {
            score = chemyScoreResolver.resolve(event.getFirstGithubId(), event.getSecondGithubId());
            Chemy entity = chemyRepository.findById(event.getChemyIdx()).get();
            entity.setChemyScore(score);
            chemyRepository.save(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
