package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.LeaderboardItem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/leaderboard")
public interface LeaderboardOperations {

    @GetMapping("/")
    List<LeaderboardItem> getLeaderboardItems() throws NotFoundException;
}
