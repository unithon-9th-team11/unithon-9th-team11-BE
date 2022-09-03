package com.gitjupalza.domain.chemy.data.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteChemyEvent {
    private final Long deletedChemyIdx;
}
