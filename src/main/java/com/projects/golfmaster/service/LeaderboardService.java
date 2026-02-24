package com.projects.golfmaster.service;

import com.projects.golfmaster.dto.PlayerSummaryDTO;
import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final ScoreService scoreService;
    private final MatchService matchService;


    public List<LeaderboardItem> getLeaderboardItems() throws NotFoundException {
        List<PlayerSummaryDTO> players = playerService.getAllPlayers();
        // Temporary code to remove players who are not in Tournament du Sol
        players.removeIf(player -> {
            String id = player.playerId();
            return !id.equals("fjodonnell")
                    && !id.equals("acarpenter")
                    && !id.equals("wghidotti")
                    && !id.equals("zhuston");
        });
        List<LeaderboardItem> leaderboardItems = new ArrayList<>();
        for (PlayerSummaryDTO player : players) {
            List<Score> playerScores = scoreService.getScoresByPlayer(player.playerId());
            LeaderboardItem leaderboardItem = new LeaderboardItem();
            int totalStrokesToPar = 0;
            BigDecimal totalPoints = BigDecimal.ZERO;
            for (Score score : playerScores) {
                if (("Tournament du Sol 2026").equals(score.getRound().getEvent().getEventName())) {
                    totalStrokesToPar = totalStrokesToPar + score.getScoreToPar();
                    totalPoints = totalPoints.add(score.getPointsEarned());
                }
            }
            leaderboardItem.setFirstName(player.playerFirstName());
            leaderboardItem.setLastName(player.playerLastName());
            leaderboardItem.setCity(player.playerCity());
            leaderboardItem.setState(player.playerState());
            leaderboardItem.setTotalPoints(totalPoints);
            leaderboardItem.setStrokesToPar(totalStrokesToPar);
            //add item to list of leaderboard items to be rendered on page
            leaderboardItems.add(leaderboardItem);
        }
        return leaderboardItems;
    }

    public List<LeaderboardItem> getTeamLeaderboardItems() throws NotFoundException {
        List<Team> teams = teamService.getAllTeams();
        //temporary code to only keep Cardinals and Eagles for Congressional Cup
        teams.removeIf(team -> !team.getTeamName().equals("Cardinals") && !team.getTeamName().equals("Eagles"));
        List<LeaderboardItem> teamLeaderboardItems = new ArrayList<>();
        for (Team team : teams) {
            String teamName = team.getTeamName();
            List<Match> matchesWon = matchService.getMatchesWonByTeam(teamName);
            BigDecimal totalPoints = BigDecimal.valueOf(matchesWon.size());
            LeaderboardItem teamLeaderboardItem = new LeaderboardItem();
            teamLeaderboardItem.setFirstName(teamName);
            teamLeaderboardItem.setTotalPoints(totalPoints);
            //add item to list of leaderboard items to be rendered on page
            teamLeaderboardItems.add(teamLeaderboardItem);
        }
        return teamLeaderboardItems;

    }
}
