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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaderboardService {
    private final TeamService teamService;
    private final ScoreRepository scoreRepository;
    private final MatchService matchService;


    public List<LeaderboardItem> getLeaderboardItems() {
        List<String> participantIds = List.of("fjodonnell", "acarpenter", "wghidotti", "zhuston");
        String eventName = "Tournament du Sol";

        // 1. Fetch scores with Player data pre-loaded
        List<Score> scores = scoreRepository.findTournamentScoresWithPlayers(participantIds, eventName);

        // 2. Safety check: If no scores yet, return empty list to keep frontend happy
        if (scores == null || scores.isEmpty()) {
            return new ArrayList<>();
        }

        // 3. Group, Map, and Tie-Break Sort
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

                    // Summing logic
                    int totalStrokes = playerScores.stream().mapToInt(Score::getScoreToPar).sum();
                    BigDecimal totalPoints = playerScores.stream()
                            .map(Score::getPointsEarned)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    item.setStrokesToPar(totalStrokes);
                    item.setTotalPoints(totalPoints);
                    return item;
                })
                // 4. Sorting logic: Primary = Points (High to Low), Secondary = Strokes (Low to High)
                .sorted(Comparator.comparing(LeaderboardItem::getTotalPoints).reversed()
                        .thenComparing(LeaderboardItem::getStrokesToPar))
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
