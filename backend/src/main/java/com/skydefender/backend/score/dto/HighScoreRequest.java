package com.skydefender.backend.score.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HighScoreRequest {
    private String username;
    private int score;
}
