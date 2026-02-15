package com.projects.golfmaster.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class LeaderboardItem {

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private BigDecimal totalPoints;
    private Integer strokesToPar;


}


