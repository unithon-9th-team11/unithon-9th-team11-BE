package com.gitjupalza.domain.chemy.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("personal-github-data")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalGithubData {
    @Id private String githubId;
    private Integer totalStar;
    private Integer totalCommit;
    private Integer totalOrganization;
}
