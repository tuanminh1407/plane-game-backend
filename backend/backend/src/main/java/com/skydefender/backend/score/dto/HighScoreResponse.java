package com.skydefender.backend.score.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HighScoreResponse {
    private String username;
    private int score;
}
