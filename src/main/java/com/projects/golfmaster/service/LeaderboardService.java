package com.projects.golfmaster.service;

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
        List<Player> players = playerService.getAllPlayers();
        // Temporary code to remove players who are not in the Congressional Cup
        players.removeIf(player -> {
            String id = player.getPlayerId();
            return !id.equals("fjodonnell")
                    && !id.equals("tfortunato")
                    && !id.equals("zrobinson")
                    && !id.equals("rschuetz");
        });
        List<LeaderboardItem> leaderboardItems = new ArrayList<>();
        for (Player player : players) {
            List<Score> playerScores = scoreService.getScoresByPlayer(player.getPlayerId());
            LeaderboardItem leaderboardItem = new LeaderboardItem();
            BigDecimal totalStrokesToPar = BigDecimal.ZERO;
            for (Score score : playerScores) {
                totalStrokesToPar = totalStrokesToPar.add(BigDecimal.valueOf(score.getScoreToPar()));
            }
            leaderboardItem.setFirstName(player.getPlayerFirstName());
            leaderboardItem.setLastName(player.getPlayerLastName());
            leaderboardItem.setCity(player.getPlayerCity());
            leaderboardItem.setState(player.getPlayerState());
            leaderboardItem.setTotalPoints(totalStrokesToPar);
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
