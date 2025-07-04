package com.projects.golfmaster.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class LeaderboardItem {

    private String playerNickname;
    private BigDecimal totalPoints;


}


