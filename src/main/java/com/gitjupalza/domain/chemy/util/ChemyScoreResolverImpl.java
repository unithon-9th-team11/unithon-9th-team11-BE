package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.github.repository.GitHubUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ChemyScoreResolverImpl implements ChemyScoreResolver {
    private final GitHubUtil gitHubUtil;

    @Override
    public Integer resolve(String firstGithubId, String secondGithubId) throws IOException {
        int num1 = getLetterCalc(firstGithubId, secondGithubId);
        int num2 = getStarCalc(firstGithubId, secondGithubId);
        int num3 = getCommitCalc(firstGithubId, secondGithubId);
        int num4 = getOrgsCalc(firstGithubId, secondGithubId);

        return num1 + num2 + num3 + num4;
    }

    // 이 항목이 제일 높으면 이름부터 찰떡궁합이에요
    private Integer getLetterCalc(String firstGithubId, String secondGithubId) {
        char fisrt[] = firstGithubId.toCharArray();
        char second[] = secondGithubId.toCharArray();

        if (firstGithubId.length() < 4 || secondGithubId.length() < 4) return 250;

        int firstNum = fisrt[0] + fisrt[1] + fisrt[2] + fisrt[3];
        int secondNum = second[0] + second[1] + second[2] + second[3];
        int gap = Math.abs(firstNum - secondNum);

        if (gap < 6) return 200;
        else if (gap < 8) return 150;
        else if (gap < 10) return 100;
        else return 50;
    }

    // 이 항목이 높으면 시너지를 통해 서로 더 빛나게 해줄 수 있을 것 같아요 : 무작위 연산 후 값이 가까우면
    private Integer getStarCalc(String firstGithubId, String secondGithubId) throws IOException {
        int firstNum = (gitHubUtil.getStarCnt(firstGithubId) % 5);
        int secondNum = (gitHubUtil.getStarCnt(secondGithubId) % 5);
        int gap = Math.abs(firstNum - secondNum);

        if (gap ==  0) return 250;
        else if (gap == 1) return 200;
        else if (gap == 2) return 150;
        else if (gap == 3) return 100;
        else return 50;
    }

    // 이 항목이 제일 높으면 서로 좋은 러닝메이트가 될 수도 있을 것 같아요 : 숫자에 대한 크기
    private Integer getCommitCalc(String firstGithubId, String secondGithubId) throws IOException {
        int firstNum = gitHubUtil.getTotalCommitCnt(firstGithubId);
        int secondNum = gitHubUtil.getTotalCommitCnt(secondGithubId);
        int gap = Math.abs(firstNum - secondNum);

        if (gap < 30) return 250;
        else if (gap < 80) return 200;
        else if (gap < 130) return 150;
        else if (gap < 160) return 100;
        else return 50;
    }

    // 이 항목이 제일 높으면 서로 보완해주는 친구가 될 것 같아요 : 차이가 클 수록
    private Integer getOrgsCalc(String firstGithubId, String secondGithubId) throws IOException {
        int firstNum = gitHubUtil.getOrgCnt(firstGithubId);
        int secondNum = gitHubUtil.getOrgCnt(secondGithubId);
        int gap = Math.abs(firstNum - secondNum);

        if (gap > 10) return 250;
        else if (gap > 8) return 200;
        else if (gap > 5) return 150;
        else if (gap > 3) return 100;
        else return 50;
    }
}


