package com.gitjupalza.domain.chemy.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteChemyResponse {
    private final Long deletedChemyIdx;
}
