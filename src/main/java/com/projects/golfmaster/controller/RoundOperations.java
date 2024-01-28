package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Round;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/round")
public interface RoundOperations {

    @GetMapping("/")
    List<Round> getAllRounds();

    @GetMapping("/roundId/{roundId}")
    Round getRoundById(@PathVariable UUID roundId) throws NotFoundException;

    @GetMapping("/eventName/{eventName}")
    List<Round> getRoundsByEventName(@PathVariable String eventName) throws NotFoundException;

    @PostMapping("/create")
    Round createRound(@RequestBody Round round);

    @PutMapping("/{roundId}")
    Round updateRound(@PathVariable UUID roundId, @RequestBody Round round) throws NotFoundException;
}
