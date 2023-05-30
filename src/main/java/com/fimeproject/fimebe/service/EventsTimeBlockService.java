package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.EventsTimeBlock;
import com.fimeproject.fimebe.entity.Timeblock;

import java.util.List;

public interface EventsTimeBlockService {
    List<EventsTimeBlock> findAll();

    List<EventsTimeBlock> findById(int id);

    EventsTimeBlock save(EventsTimeBlock theEventsTimeBlock);
}
