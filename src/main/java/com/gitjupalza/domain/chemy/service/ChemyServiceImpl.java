package com.gitjupalza.domain.chemy.service;

import com.gitjupalza.global.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.data.event.CreateChemyEvent;
import com.gitjupalza.domain.chemy.data.event.DeleteChemyEvent;
import com.gitjupalza.domain.chemy.data.event.QueryChemyEvent;
import com.gitjupalza.domain.chemy.exception.ChemyNotFoundException;
import com.gitjupalza.global.chemy.repository.ChemyRepository;
import com.gitjupalza.global.chemy.util.ChemyConverter;
import com.gitjupalza.domain.chemy.util.ChemyGenerator;
import com.gitjupalza.global.member.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ChemyServiceImpl implements ChemyService {
    private final ChemyRepository chemyRepository;
    private final ChemyGenerator chemyGenerator;
    private final ChemyConverter chemyConverter;
    private final LoginUserService loginUserService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Long createChemy(String firstGithubId, String secondGithubId) {
        final ChemyDto dto = chemyGenerator.generate(firstGithubId, secondGithubId);

        final AtomicReference<Chemy> atomic = new AtomicReference<>();
        chemyRepository.findByFirstGithubIdAndSecondGithubId(firstGithubId, secondGithubId)
                .ifPresentOrElse(
                        entity -> {
                            entity.setChemyScore(dto.getChemyScore());
                            atomic.set(entity);
                        }, () -> {
                            Chemy entity = chemyConverter.toEntity(dto);
                            atomic.set(entity);
                        });

        final Chemy entity = atomic.get();
        final Chemy savedEntity = chemyRepository.save(entity);
;
        try {
            Long issuerIdx = loginUserService.getLoginUserIdx();
            final CreateChemyEvent event = chemyConverter.toCreateEvent(savedEntity, issuerIdx);
            applicationEventPublisher.publishEvent(event);
        } catch (Exception ignored) {}

        return savedEntity.getIdx();
    }

    @Override
    public ChemyDto queryByIdx(Long idx) {
        final Chemy entity = chemyRepository.findById(idx)
                .orElseThrow(() -> new ChemyNotFoundException(String.format("idx가 %d인 궁합정보를 찾을 수 없습니다! 궁합정보를 조회할 수 없습니다!", idx)));

        QueryChemyEvent event = chemyConverter.toQueryEvent(entity);
        applicationEventPublisher.publishEvent(event);

        return chemyConverter.toDto(entity);
    }

    @Override
    public Long deleteChemy(Long idx) {
        if(!chemyRepository.existsById(idx)) throw new ChemyNotFoundException(String.format("idx가 %d인 궁합정보를 찾을 수 없습니다! 궁합정보를 삭제할 수 없습니다!", idx));
        chemyRepository.deleteById(idx);

        DeleteChemyEvent event = chemyConverter.toDeleteEvent(idx);
        applicationEventPublisher.publishEvent(event);

        return idx;
    }
}
