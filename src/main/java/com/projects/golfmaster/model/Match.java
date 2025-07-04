package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity(name = "matches")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
public class Match {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID matchId;
    private String matchName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "round_id")
    private Round round;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matches_teams")
    @JsonIgnoreProperties({"players", "matches"})
    private List<Team> teams;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matches_players")
    @JsonIncludeProperties("playerId")
    private List<Player> players;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_winner")
    @JsonIgnoreProperties({"players", "matches"})
    private Team teamWinner;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_loser")
    @JsonIgnoreProperties({"players", "matches"})
    private Team teamLoser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_winner")
    @JsonIncludeProperties("playerId")
    private Player playerWinner;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_loser")
    @JsonIncludeProperties("playerId")
    private Player playerLoser;
    private Integer holesWonBy;
    private Integer holesRemaining;
}
