package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dto.DateRangeDTO;
import com.fimeproject.fimebe.dto.EventAndTimeBlockDTO;
import com.fimeproject.fimebe.entity.Events;
import com.fimeproject.fimebe.entity.EventsTimeBlock;
import com.fimeproject.fimebe.service.EventsService;
import com.fimeproject.fimebe.service.EventsTimeBlockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<EventAndTimeBlockDTO> findAll() {
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

            EventAndTimeBlockDTO eventAndTimeBlockDTO = new EventAndTimeBlockDTO(e.getId(), e.getName(), e.getDescription(), dateRanges);

            eventDTOList.add(eventAndTimeBlockDTO);
        }

        return eventDTOList;
    }

    @PostMapping("/create-events")
    public ResponseEntity<Map<Events, List<EventsTimeBlock>>> createEvent(@RequestBody List<EventAndTimeBlockDTO> eventAndTimeBlockDTOArr) {
        Map<Events, List<EventsTimeBlock>> response = new HashMap<>();
        for (EventAndTimeBlockDTO etb : eventAndTimeBlockDTOArr) {
            Events createdEvent = eventsService.createEvent(new Events(etb.getName(), etb.getDescription()));
            List<EventsTimeBlock> timeBlockList = new ArrayList<>();
            for (DateRangeDTO timeBlock : etb.getDateRanges()) {
                EventsTimeBlock tb = eventsTimeBlockService.createTimeBlock(new EventsTimeBlock(timeBlock.getStartDate(), timeBlock.getEndDate(), createdEvent.getId()));
                timeBlockList.add(tb);
            }
            response.put(createdEvent, timeBlockList);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
