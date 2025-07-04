package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.LeaderboardItem;
import com.projects.golfmaster.model.Player;
import com.projects.golfmaster.model.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {

    private final PlayerService playerService;
    private final ScoreService scoreService;


    public List<LeaderboardItem> getLeaderboardItems() throws NotFoundException {
        List<Player> players = playerService.getAllPlayers();
        List<LeaderboardItem> leaderboardItems = new ArrayList<>();
        for (Player player : players) {
            List<Score> playerScores = scoreService.getScoresByPlayer(player.getPlayerId());
            LeaderboardItem leaderboardItem = new LeaderboardItem();
            BigDecimal totalPoints = BigDecimal.ZERO;
            for (Score score : playerScores) {
                totalPoints = totalPoints.add(score.getPointsEarned());
            }
            leaderboardItem.setPlayerNickname(player.getPlayerNickname());
            leaderboardItem.setTotalPoints(totalPoints);
            //add item to list of leaderboard items to be rendered on page
            leaderboardItems.add(leaderboardItem);
        }
        return leaderboardItems;
    }
}
