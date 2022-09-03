package com.gitjupalza.domain.chemy.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chemy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String firstGithubId;
    private String secondGithubId;
    private Integer chemyScore;
}
