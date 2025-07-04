package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/event")
public interface EventOperations {

    @GetMapping("/")
    List<Event> getAllEvents();

    @GetMapping("/{eventName}")
    Event getEventByName(@PathVariable String eventName) throws NotFoundException;

    @PostMapping("/create")
    Event createEvent(@RequestBody Event event);

    @PutMapping("/{eventName}")
    Event updateEvent(@PathVariable String eventName, @RequestBody Event eventToUpdate) throws NotFoundException;
}
