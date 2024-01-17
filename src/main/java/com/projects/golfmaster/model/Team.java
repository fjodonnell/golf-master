package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "teams")
@Table(schema = "jpa")
@NoArgsConstructor
@DynamicUpdate
public class Team {

    @Id
    private String teamName;
    @ManyToMany(mappedBy = "teamList", fetch = FetchType.LAZY)
    private List<Player> playerList;
    @ManyToMany(mappedBy = "teamList", fetch = FetchType.LAZY)
    private List<Match> matchList;



    //Constructor

    public Team(String teamName) {
        this.teamName = teamName;
    }

    //Getters and Setters

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
