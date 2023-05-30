package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.entity.Events;
import com.fimeproject.fimebe.service.EventsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsRestController {
    private EventsService eventsService;

    public EventsRestController(EventsService theEventsService) {
        eventsService = theEventsService;
    }

    @GetMapping("/all-events")
    public List<Events> findAll() {return eventsService.findAll();}

    @GetMapping("/event/{id}")
    public List<Events> findAllAvailableDatesGivenEvent(@PathVariable int id) {
        return eventsService.findAllAvailableDatesGivenEvent(id);
    }
}
