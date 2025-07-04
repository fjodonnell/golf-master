package com.projects.golfmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity(name = "events")
@Table
@NoArgsConstructor
@DynamicUpdate
@Data
public class Event {

    @Id
    private String eventName;
    private String eventLocation;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;

    //Constructor

    public Event(String eventName) {
        this.eventName = eventName;
    }
}
