package com.skydefender.backend.score;

import com.skydefender.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HighScoreRepository extends JpaRepository<HighScore, Long> {

    List<HighScore> findTop10ByOrderByScoreDesc();

    Optional<HighScore> findTopByUserOrderByScoreDesc(User user);

}
