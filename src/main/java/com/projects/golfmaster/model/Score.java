package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "scores")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
public class Score {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID scoreId;
    private Integer score;
    private Integer scoreToPar;
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
    private Integer pars;
    private Integer birdies;
    private Integer eagles;
    private BigDecimal pointsEarned;
}
