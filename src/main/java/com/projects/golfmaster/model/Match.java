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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_winner")
    private Team teamWinner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_loser")
    private Team teamLoser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_winner")
    private Player playerWinner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_loser")
    private Player playerLoser;

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

    public Team getTeamWinner() {
        return teamWinner;
    }

    public void setTeamWinner(Team teamWinner) {
        this.teamWinner = teamWinner;
    }

    public Team getTeamLoser() {
        return teamLoser;
    }

    public void setTeamLoser(Team teamLoser) {
        this.teamLoser = teamLoser;
    }

    public Player getPlayerWinner() {
        return playerWinner;
    }

    public void setPlayerWinner(Player playerWinner) {
        this.playerWinner = playerWinner;
    }

    public Player getPlayerLoser() {
        return playerLoser;
    }

    public void setPlayerLoser(Player playerLoser) {
        this.playerLoser = playerLoser;
    }
}
