package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "players")
@Table
@NoArgsConstructor
@DynamicUpdate
@JsonIgnoreProperties("singlesMatches")
public class Player {

    @Id
    private String playerId;
    private String playerFirstName;
    private String playerLastName;
    private String playerNickname;
    private int playerAge;
    private String playerCity;
    private String playerState;
    private int playerHandicap;
    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"players", "matches"})
    private List<Team> teams;
    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    private List<Match> singlesMatches;
    private String passwordHash;
    private String role;

    //Constructor

    public Player(String playerId, String playerFirstName, String playerLastName, String passwordHash, String role) {
        this.playerId = playerId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    //Getters and Setters

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerCity() {
        return playerCity;
    }

    public void setPlayerCity(String playerCity) {
        this.playerCity = playerCity;
    }

    public String getPlayerState() {
        return playerState;
    }

    public void setPlayerState(String playerState) {
        this.playerState = playerState;
    }

    public int getPlayerHandicap() {
        return playerHandicap;
    }

    public void setPlayerHandicap(int playerHandicap) {
        this.playerHandicap = playerHandicap;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getSinglesMatches() {
        return singlesMatches;
    }

    public void setSinglesMatches(List<Match> singlesMatches) {
        this.singlesMatches = singlesMatches;
    }
}
