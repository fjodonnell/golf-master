package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "players")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
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
}
