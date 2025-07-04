package com.projects.golfmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity(name = "teams")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
@JsonIgnoreProperties("matches")
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

}
