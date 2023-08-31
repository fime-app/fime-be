package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dto.EventAvailabilityDTO;
import com.fimeproject.fimebe.entity.Availability;
import com.fimeproject.fimebe.service.AvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AvailabilityRestController {
    private AvailabilityService availabilityService;

    public AvailabilityRestController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping("/event/{id}")
    public List<EventAvailabilityDTO> getAllById(@PathVariable int id) {
        List<Availability> availability = availabilityService.findByEventId(id);
        for (Availability a : availability) {
            System.out.println(a);
        }
        return null;
    }
}
