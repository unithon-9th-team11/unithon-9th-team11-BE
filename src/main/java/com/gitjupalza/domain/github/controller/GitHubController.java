package com.gitjupalza.domain.github.controller;

import com.gitjupalza.domain.github.repository.GitHubCrawlUtil;
import com.gitjupalza.domain.github.repository.GitHubUtil;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/github")
public class GitHubController {
    private final GitHubUtil gitHubUtil;
    private final GitHubCrawlUtil gitHubCrawlUtil;

    @GetMapping("/test")
    public ResponseEntity test() throws IOException, JSONException {

        return ResponseEntity.ok().body("commit 수 : "+gitHubUtil.getTotalCommitCnt("210-reverof"));
    }

    @GetMapping("/crawling-test")
    public ResponseEntity crawlTest() {

        return ResponseEntity.ok().body(gitHubCrawlUtil.getTotalContribution() + "~~");
    }
}
