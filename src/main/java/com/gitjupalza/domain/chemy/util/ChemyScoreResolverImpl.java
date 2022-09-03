package com.gitjupalza.domain.chemy.util;

import com.gitjupalza.domain.chemy.data.entity.PersonalGithubData;
import com.gitjupalza.domain.chemy.repository.PersonalGithubDataRepository;
import com.gitjupalza.domain.github.repository.GitHubUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ChemyScoreResolverImpl implements ChemyScoreResolver {
    private final GitHubUtil gitHubUtil;
    private final PersonalGithubDataRepository personalGithubDataRepository;

    @Override
    public Integer resolve(String firstGithubId, String secondGithubId) throws IOException {
        int num1;
        char[] first = firstGithubId.toCharArray();
        char[] second = secondGithubId.toCharArray();

        if (firstGithubId.length() < 4 || secondGithubId.length() < 4) num1 = 250;

        int firstNum1 = first[0] + first[1] + first[2] + first[3];
        int secondNum1 = second[0] + second[1] + second[2] + second[3];
        int gap = Math.abs(firstNum1 - secondNum1);

        if (gap < 6) num1 = 200;
        else if (gap < 8) num1 = 150;
        else if (gap < 10) num1 = 100;
        else num1 = 50;

        /////////////////////////

        int num2;
        int firstNumStar = (gitHubUtil.getStarCnt(firstGithubId) % 5);
        int secondNumStar = (gitHubUtil.getStarCnt(secondGithubId) % 5);
        int gap2 = Math.abs(firstNumStar - secondNumStar);

        if (gap2 ==  0) num2 = 250;
        else if (gap2 == 1) num2 = 200;
        else if (gap2 == 2) num2 = 150;
        else if (gap2 == 3) num2 = 100;
        else num2 = 50;



        ///////////////
        int num3;
        int firstNumCommit = gitHubUtil.getTotalCommitCnt(firstGithubId);
        int secondNumCommit = gitHubUtil.getTotalCommitCnt(secondGithubId);
        int gap3 = Math.abs(firstNumCommit - secondNumCommit);

        if (gap3 < 30) num3 =  250;
        else if (gap3 < 80) num3 =  200;
        else if (gap3 < 130) num3 = 150;
        else if (gap3 < 160) num3 =  100;
        else num3 = 50;


        ///////////////
        int num4;
        int firstNumOrg = gitHubUtil.getOrgCnt(firstGithubId);
        int secondNumOrg = gitHubUtil.getOrgCnt(secondGithubId);
        int gap4 = Math.abs(firstNumOrg - secondNumOrg);

        if (gap4 > 10) num4 = 250;
        else if (gap4 > 8) num4 = 200;
        else if (gap4 > 5) num4 = 150;
        else if (gap4 > 3) num4 = 100;
        else num4 = 50;

        PersonalGithubData firstPersonalGithubData = new PersonalGithubData(firstGithubId, firstNumStar, firstNumCommit, firstNumOrg);
        PersonalGithubData secondPersonalGithubData = new PersonalGithubData(secondGithubId, secondNumStar, secondNumCommit, secondNumOrg);

        personalGithubDataRepository.save(firstPersonalGithubData);
        personalGithubDataRepository.save(secondPersonalGithubData);

        return num1 + num2 + num3 + num4;
    }

}


