package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.entity.Timeblock;
import com.fimeproject.fimebe.service.TimeblockService;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeblockRestController {
    // inject employee DAO directly
    private TimeblockService timeblockService;

    public TimeblockRestController(TimeblockService theTimeblockService) {
        timeblockService = theTimeblockService;
    }

    // expose "/timeblocks" and return a list of all timeblocks
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/timeblocks")
    public List<Timeblock> findAll() {
        return timeblockService.findAll();
    }

    // add mapping for GET /timeblock/{name}
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/timeblocks/{name}")
    public List<Timeblock> getTimeblocks(@PathVariable String name) {
        List<Timeblock> timeblocks = timeblockService.findByName(name);

        if (timeblocks == null) {
            throw new RuntimeException("Name not found - " + name);
        }

        return timeblocks;
    }


}
