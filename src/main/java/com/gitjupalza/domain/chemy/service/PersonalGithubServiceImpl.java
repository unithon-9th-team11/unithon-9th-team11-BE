package com.gitjupalza.domain.chemy.service;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;
import com.gitjupalza.domain.chemy.data.entity.PersonalGithubData;
import com.gitjupalza.domain.chemy.exception.UnknownPersonalGithubDataException;
import com.gitjupalza.domain.chemy.repository.PersonalGithubDataRepository;
import com.gitjupalza.domain.chemy.util.PersonalGithubDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalGithubServiceImpl implements PersonalGithubService {
    private final PersonalGithubDataRepository personalGithubDataRepository;
    private final PersonalGithubDataConverter personalGithubDataConverter;

    @Override
    public PersonalGithubDataDto queryById(String githubId) {
        PersonalGithubData entity = personalGithubDataRepository
                .findById(githubId)
                .orElseThrow(() -> new UnknownPersonalGithubDataException(String.format("githubId가 %s인 깃허브 개인정보를 찾을 수 없습니다!", githubId)));
        return personalGithubDataConverter.toDto(entity);
    }
}
