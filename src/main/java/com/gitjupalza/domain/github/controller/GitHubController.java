package com.gitjupalza.domain.github.controller;

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

    @GetMapping("/test")
    public ResponseEntity test() throws IOException, JSONException {

        return ResponseEntity.ok().body("star 수 : "+gitHubUtil.getStarCnt("210-reverof"));
    }
}
