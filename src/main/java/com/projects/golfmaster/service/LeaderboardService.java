package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.*;
import com.projects.golfmaster.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaderboardService {
    private final TeamService teamService;
    private final ScoreRepository scoreRepository;
    private final MatchService matchService;


    public List<LeaderboardItem> getLeaderboardItems() {
        List<String> participantIds = List.of("fjodonnell", "acarpenter", "wghidotti", "zhuston");
        String tournamentId = "d050abf9-a7b4-486b-a13f-85b112aa220f";

        // 1. Fetch everything (Scores + Players) in 1 query
        List<Score> scores = scoreRepository.findTournamentScoresWithPlayers(participantIds, tournamentId);

        // 2. Group by Player and build the DTOs
        return scores.stream()
                .collect(Collectors.groupingBy(Score::getPlayer))
                .entrySet().stream()
                .map(entry -> {
                    Player p = entry.getKey();
                    List<Score> playerScores = entry.getValue();

                    LeaderboardItem item = new LeaderboardItem();
                    item.setFirstName(p.getPlayerFirstName());
                    item.setLastName(p.getPlayerLastName());
                    item.setCity(p.getPlayerCity());
                    item.setState(p.getPlayerState());

                    // Calculate totals from the list
                    item.setStrokesToPar(playerScores.stream().mapToInt(Score::getScoreToPar).sum());
                    item.setTotalPoints(playerScores.stream()
                            .map(Score::getPointsEarned)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));

                    return item;
                })
                // 1. Sort by points (reversed for descending order), then by strokes to par if needed
                .sorted(Comparator.comparing(LeaderboardItem::getTotalPoints).reversed()
                        .thenComparing(LeaderboardItem::getStrokesToPar))
                // 2. Collect into the final list
                .collect(Collectors.toList());
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
