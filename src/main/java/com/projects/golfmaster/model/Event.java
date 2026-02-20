package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "events")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID eventId;
    private String eventName;
    private String eventLocation;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;

    //Constructor

    public Event(String eventName) {
        this.eventName = eventName;
    }
}
