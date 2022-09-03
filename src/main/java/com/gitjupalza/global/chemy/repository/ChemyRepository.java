package com.gitjupalza.global.chemy.repository;

import com.gitjupalza.domain.chemy.data.entity.Chemy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChemyRepository extends JpaRepository<Chemy, Long> {
    Optional<Chemy> findByFirstGithubIdAndSecondGithubId(String firstGithubId, String secondGithubId);
}
