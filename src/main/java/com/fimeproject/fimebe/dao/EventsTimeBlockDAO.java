package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.EventsTimeBlock;

import java.util.List;

public interface EventsTimeBlockDAO {
    List<EventsTimeBlock> findAll();

    List<EventsTimeBlock> findById(int id);

    EventsTimeBlock save(EventsTimeBlock eventsTimeBlock);

}
