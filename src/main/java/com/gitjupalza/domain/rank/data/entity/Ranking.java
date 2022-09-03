package com.gitjupalza.domain.rank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "ranking")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    private Long idx;
    @Indexed private Long viewerIdx;
    private Long chemyIdx;
}
