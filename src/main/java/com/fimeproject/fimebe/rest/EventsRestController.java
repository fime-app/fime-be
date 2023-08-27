package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dto.DateRangeDTO;
import com.fimeproject.fimebe.dto.EventAndTimeBlockDTO;
import com.fimeproject.fimebe.entity.Events;
import com.fimeproject.fimebe.entity.EventsTimeBlock;
import com.fimeproject.fimebe.service.EventsService;
import com.fimeproject.fimebe.service.EventsTimeBlockService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsRestController {
    private EventsService eventsService;
    private EventsTimeBlockService eventsTimeBlockService;

    public EventsRestController(EventsService theEventsService, EventsTimeBlockService eventsTimeBlockService) {

        this.eventsService = theEventsService;

        this.eventsTimeBlockService = eventsTimeBlockService;
    }

    @GetMapping("/all-events")
    public Map<String, List<EventAndTimeBlockDTO>> findAll() {
        List<Events> events = eventsService.findAll();
        Map<String, List<EventAndTimeBlockDTO>> response = new HashMap<>();
        List<EventAndTimeBlockDTO> eventDTOList = new ArrayList<>();

        for (Events e : events) {
            List<EventsTimeBlock> timeBlocks = eventsTimeBlockService.findById(e.getId());

            List<DateRangeDTO> dateRanges = new ArrayList<>();
            for (EventsTimeBlock timeBlock : timeBlocks) {
                DateRangeDTO dateRangeDTO = new DateRangeDTO(timeBlock.getStartDate(), timeBlock.getEndDate());
                dateRanges.add(dateRangeDTO);
            }

            EventAndTimeBlockDTO eventAndTimeBlockDTO = new EventAndTimeBlockDTO(e.getId(), e.getName(), dateRanges);

            eventDTOList.add(eventAndTimeBlockDTO);
        }
        response.put("result", eventDTOList);

        return response;
    }

    @GetMapping("/event/{id}")
    public List<Events> findAllAvailableDatesGivenEvent(@PathVariable int id) {
        return eventsService.findAllAvailableDatesGivenEvent(id);
    }
}
