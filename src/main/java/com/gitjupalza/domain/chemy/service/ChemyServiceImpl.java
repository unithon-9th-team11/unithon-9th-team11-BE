package com.gitjupalza.domain.chemy.service;

import com.gitjupalza.domain.chemy.data.dto.ChemyDto;
import com.gitjupalza.domain.chemy.data.entity.Chemy;
import com.gitjupalza.domain.chemy.exception.ChemyNotFoundException;
import com.gitjupalza.domain.chemy.repository.ChemyRepository;
import com.gitjupalza.domain.chemy.util.ChemyConverter;
import com.gitjupalza.domain.chemy.util.ChemyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemyServiceImpl implements ChemyService {
    private final ChemyRepository chemyRepository;
    private final ChemyGenerator chemyGenerator;
    private final ChemyConverter chemyConverter;

    @Override
    public Long createChemy(String firstGithubId, String secondGithubId) {
        final ChemyDto dto = chemyGenerator.generate(firstGithubId, secondGithubId);
        final Chemy entity = chemyConverter.toEntity(dto);
        final Chemy savedEntity = chemyRepository.save(entity);
        return savedEntity.getIdx();
    }

    @Override
    public ChemyDto queryByIdx(Long idx) {
        final Chemy entity = chemyRepository.findById(idx)
                .orElseThrow(() -> new ChemyNotFoundException(String.format("idx가 %d인 궁합정보를 찾을 수 없습니다! 궁합정보를 조회할 수 없습니다!", idx)));
        return chemyConverter.toDto(entity);
    }

    @Override
    public Long deleteChemy(Long idx) {
        if(!chemyRepository.existsById(idx)) throw new ChemyNotFoundException(String.format("idx가 %d인 궁합정보를 찾을 수 없습니다! 궁합정보를 삭제할 수 없습니다!", idx));
        chemyRepository.deleteById(idx);
        return idx;
    }
}
