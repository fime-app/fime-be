package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.EventsDAO;
import com.fimeproject.fimebe.entity.Events;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService{
    private EventsDAO eventsDAO;

    public EventsServiceImpl(EventsDAO eventsDAO) {
        this.eventsDAO = eventsDAO;
    }

    @Override
    public List<Events> findAll() {
        return eventsDAO.findAll();
    }

    @Override
    public List<Events> findAllAvailableDatesGivenEvent(int id) {
        // Get a list of all users for this event and their available dates
        // 1. Search in Availability and find all the names that are participating
        // 2. For each participating name there is an associated id. Find all of the columns associated with availability_id in the availability_timeblocks
        // 3. Find all common dates
        return eventsDAO.findById(id);
    }


}
