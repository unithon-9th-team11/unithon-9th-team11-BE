package com.gitjupalza.domain.chemy.service;

import com.gitjupalza.domain.chemy.data.dto.PersonalGithubDataDto;

public interface PersonalGithubService {
    PersonalGithubDataDto queryById(String githubId);
}
