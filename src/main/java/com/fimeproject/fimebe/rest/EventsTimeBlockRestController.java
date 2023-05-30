package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.entity.EventsTimeBlock;
import com.fimeproject.fimebe.service.EventsTimeBlockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsTimeBlockRestController {
    private EventsTimeBlockService eventsTimeBlockService;

    public EventsTimeBlockRestController(EventsTimeBlockService eventsTimeBlockService) {
        this.eventsTimeBlockService = eventsTimeBlockService;
    }

    @GetMapping("/eventsTimeBlocks")
    public List<EventsTimeBlock> findAll() {return eventsTimeBlockService.findAll();}

    @GetMapping("/eventsTimeBlocks/{id}")
    public List<EventsTimeBlock> findById(@PathVariable int id) {
        List<EventsTimeBlock> timeBlocks = eventsTimeBlockService.findById(id);

        if (timeBlocks == null) {
            throw new RuntimeException("TimeBlocks not found - " + id);
        }

        return timeBlocks;
    }

//    @PostMapping("/eventsTimeBlocks")
}
