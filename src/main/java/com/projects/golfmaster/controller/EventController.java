package com.projects.golfmaster.controller;

import com.projects.golfmaster.exception.EventNotFoundException;
import com.projects.golfmaster.model.Event;
import com.projects.golfmaster.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController implements EventOperations{

    @Autowired
    EventService eventService;

    @Override
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Override
    public Event getEventByName(String eventName) throws EventNotFoundException {
        return eventService.getEventByName(eventName);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(String eventName, Event eventToUpdate) throws EventNotFoundException{
        return eventService.updateEvent(eventName, eventToUpdate);
    }
}
