package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity(name = "matches")
@Table
@NoArgsConstructor
@DynamicUpdate
public class Match {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID matchId;
    private String matchName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
    private Round round;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matches_teams")
    private List<Team> teams;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matches_players")
    private List<Player> players;

    //Getters and Setters

    public UUID getMatchId() {
        return matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
