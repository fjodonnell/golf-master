package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity(name = "scores")
@Table
@NoArgsConstructor
@DynamicUpdate
public class Score {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID scoreId;
    private Integer score;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    @JsonIncludeProperties("playerId")
    private Player player;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "match_id")
    @JsonIncludeProperties({"matchId", "matchName"})
    private Match match;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "round_id")
    private Round round;

    //Getters and Setters

    public UUID getScoreId() {
        return scoreId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
