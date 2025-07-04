package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity(name = "rounds")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
public class Round {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID roundId;
    private String roundName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_name")
    private Event event;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_name")
    private Course course;

}
