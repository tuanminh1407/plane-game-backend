package com.skydefender.backend.score.dto;

import com.skydefender.backend.score.HighScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/highscores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HighScoreController {

    private final HighScoreService highScoreService;

    @PostMapping
    public ResponseEntity<HighScoreResponse> submitScore(
            @RequestBody HighScoreRequest request) {

        return ResponseEntity.ok(
                highScoreService.submitScore(request)
        );
    }

    @GetMapping("/top")
    public ResponseEntity<List<HighScoreResponse>> getTop10() {

        return ResponseEntity.ok(
                highScoreService.getTop10()
        );
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<HighScoreResponse> getUserBest(
            @PathVariable String username) {

        return ResponseEntity.ok(
                highScoreService.getUserBestScore(username)
        );
    }
}
