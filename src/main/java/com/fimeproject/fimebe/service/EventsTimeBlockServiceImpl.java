package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.EventsTimeBlockDAO;
import com.fimeproject.fimebe.entity.EventsTimeBlock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsTimeBlockServiceImpl implements EventsTimeBlockService{
    private EventsTimeBlockDAO eventsTimeBlockDAO;

    public EventsTimeBlockServiceImpl(EventsTimeBlockDAO eventsTimeBlockDAO) {
        this.eventsTimeBlockDAO = eventsTimeBlockDAO;
    }

    @Override
    public List<EventsTimeBlock> findAll() {
        return this.eventsTimeBlockDAO.findAll();
    }

    @Override
    public List<EventsTimeBlock> findById(int id) {
        return this.eventsTimeBlockDAO.findById(id);
    }

    @Override
    public EventsTimeBlock save(EventsTimeBlock theEventsTimeBlock) {
        return this.eventsTimeBlockDAO.save(theEventsTimeBlock);
    }
}
