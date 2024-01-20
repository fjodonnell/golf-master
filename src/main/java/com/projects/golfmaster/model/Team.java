package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "teams")
@Table
@NoArgsConstructor
@DynamicUpdate
//@JsonIgnoreProperties("matches")
public class Team {

    @Id
    private String teamName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teams_players")
    @JsonIgnoreProperties("teams")
    private List<Player> players;
    @ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("teams")
    private List<Match> matches;



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

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
