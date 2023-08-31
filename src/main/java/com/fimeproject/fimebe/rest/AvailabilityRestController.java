package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dto.EventAvailabilityDTO;
import com.fimeproject.fimebe.entity.Availability;
import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;
import com.fimeproject.fimebe.service.AvailabilityService;
import com.fimeproject.fimebe.service.AvailabilityTimeBlockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AvailabilityRestController {
    private AvailabilityService availabilityService;

    private AvailabilityTimeBlockService availabilityTimeblockService;

    public AvailabilityRestController(AvailabilityService availabilityService, AvailabilityTimeBlockService availabilityTimeblockService) {
        this.availabilityService = availabilityService;
        this.availabilityTimeblockService = availabilityTimeblockService;
    }

    @GetMapping("/event/{id}")
    public List<EventAvailabilityDTO> getAllById(@PathVariable int id) {
        List<Availability> availability = availabilityService.findByEventId(id);
        for (Availability a : availability) {
            List<AvailabilityTimeBlock> availabilityTimeBlockList = availabilityTimeblockService.findTimeBlockByAvailabilityId(a.getId());
            System.out.println(a);
            for (AvailabilityTimeBlock atb : availabilityTimeBlockList){
                System.out.println(atb);
            }
        }
        return null;
    }
}
