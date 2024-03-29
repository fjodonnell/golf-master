package com.projects.golfmaster.service;

import com.projects.golfmaster.exception.NotFoundException;
import com.projects.golfmaster.model.Event;
import com.projects.golfmaster.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventByName(String eventName) throws NotFoundException {
        Optional<Event> retrievedEvent = eventRepository.findById(eventName);
        return retrievedEvent.orElseThrow(() -> new NotFoundException("Event not Found"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(String eventName, Event eventToUpdate) throws NotFoundException {
        Optional<Event> potentialEvent = eventRepository.findById(eventName);
        if (potentialEvent.isPresent()) {
            Event existingEvent = potentialEvent.get();
            existingEvent.setEventName(eventToUpdate.getEventName());
            existingEvent.setEventLocation(eventToUpdate.getEventLocation());
            existingEvent.setEventStartDate(eventToUpdate.getEventStartDate());
            existingEvent.setEventEndDate(eventToUpdate.getEventEndDate());
            return eventRepository.save(existingEvent);
        } else {
            throw new NotFoundException("Event Not Found");
        }
    }
}
