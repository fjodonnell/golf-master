package com.projects.golfmaster.repository;

import com.projects.golfmaster.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
