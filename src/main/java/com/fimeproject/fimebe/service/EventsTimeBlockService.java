package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.EventsTimeBlock;

import java.util.List;

public interface EventsTimeBlockService {
    List<EventsTimeBlock> findAll();

    List<EventsTimeBlock> findById(int id);

    EventsTimeBlock createTimeBlock(EventsTimeBlock theEventsTimeBlock);
}
