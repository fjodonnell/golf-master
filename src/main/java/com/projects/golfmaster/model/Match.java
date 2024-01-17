package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity(name = "matches")
@Table(schema = "jpa")
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
    @JoinTable(name = "matches_teams", schema = "jpa")
    private List<Team> teamList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matches_players", schema = "jpa")
    private List<Player> playerList;

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

    public List<Team> getTeamsList() {
        return teamList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamList = teamsList;
    }

    public List<Player> getPlayersList() {
        return playerList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playerList = playersList;
    }
}
