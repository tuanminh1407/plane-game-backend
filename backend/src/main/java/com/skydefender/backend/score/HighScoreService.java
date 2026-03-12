package com.skydefender.backend.score;

import com.skydefender.backend.score.dto.HighScoreRequest;
import com.skydefender.backend.score.dto.HighScoreResponse;
import com.skydefender.backend.user.User;
import com.skydefender.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HighScoreService {

    private final HighScoreRepository highScoreRepository;
    private final UserRepository userRepository;

    public HighScoreResponse submitScore(HighScoreRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        HighScore highScore = new HighScore();
        highScore.setUser(user);
        highScore.setScore(request.getScore());

        highScoreRepository.save(highScore);

        return new HighScoreResponse(
                user.getUsername(),
                request.getScore()
        );
    }

    public List<HighScoreResponse> getTop10() {

        return highScoreRepository.findTop10ByOrderByScoreDesc()
                .stream()
                .map(h -> new HighScoreResponse(
                        h.getUser().getUsername(),
                        h.getScore()
                ))
                .toList();
    }

    public HighScoreResponse getUserBestScore(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        HighScore highScore = highScoreRepository
                .findTopByUserOrderByScoreDesc(user)
                .orElseThrow(() -> new RuntimeException("No score found"));

        return new HighScoreResponse(
                username,
                highScore.getScore()
        );
    }
}
