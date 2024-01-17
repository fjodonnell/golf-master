package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity(name = "rounds")
@Table(schema = "jpa")
@NoArgsConstructor
@DynamicUpdate
public class Round {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID roundId;
    private String roundName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_name")
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_name")
    private Course course;

    //Getters and Setters

    public UUID getRoundId() {
        return roundId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
