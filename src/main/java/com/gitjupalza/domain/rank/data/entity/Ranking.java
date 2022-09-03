package com.gitjupalza.domain.rank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "ranking")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    @Id private Long idx;
    @Indexed private Long viewerIdx;
    @Indexed private Long chemyIdx;
}
