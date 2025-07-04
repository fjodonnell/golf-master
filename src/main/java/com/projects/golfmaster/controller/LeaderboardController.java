package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.LeaderboardItem;
import com.projects.golfmaster.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderboardController implements LeaderboardOperations {

    @Autowired
    LeaderboardService leaderboardService;

    @Override
    public List<LeaderboardItem> getLeaderboardItems() throws NotFoundException {
        return leaderboardService.getLeaderboardItems();
    }
}
