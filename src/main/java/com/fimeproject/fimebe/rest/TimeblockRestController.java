package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dao.TimeblockDAO;
import com.fimeproject.fimebe.entity.Timeblock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeblockRestController {
    // inject employee DAO directly

    private TimeblockDAO timeblockDAO;

    public TimeblockRestController(TimeblockDAO theTimeblockDAO) {
        timeblockDAO = theTimeblockDAO;
    }

    // expose "/timeblocks" and return a list of all timeblocks
    @GetMapping("/timeblocks")
    public List<Timeblock> findAll() {
        return timeblockDAO.findAll();
    }
}
