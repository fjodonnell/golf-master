package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "players")
@NoArgsConstructor
@DynamicUpdate
@Data
public class Player {

    @Id
    private String playerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String playerFirstName;
    private String playerLastName;
    private String playerNickname;
    private Integer playerAge;
    private String playerCity;
    private String playerState;
    private Integer playerHandicap;
    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"players", "matches"})
    private List<Team> teams;
    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    private List<Match> singlesMatches;

    //Constructor

    public Player(String playerId, String playerFirstName, String playerLastName) {
        this.playerId = playerId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
    }
}
