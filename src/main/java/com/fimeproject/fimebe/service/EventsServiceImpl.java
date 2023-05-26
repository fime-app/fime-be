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
}
