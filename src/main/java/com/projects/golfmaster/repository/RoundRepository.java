package com.projects.golfmaster.repository;

import com.projects.golfmaster.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoundRepository extends JpaRepository<Round, UUID> {

    Optional<List<Round>> findByEvent_EventName(String eventName);
}
