package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.entity.Events;
import com.fimeproject.fimebe.service.EventsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsRestController {
    private EventsService eventsService;

    public EventsRestController(EventsService theEventsService) {
        eventsService = theEventsService;
    }

    @GetMapping("/events")
    public List<Events> findAll() {return eventsService.findAll();}
}
