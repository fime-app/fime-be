package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.Events;

import java.util.List;

public interface EventsService {
    List<Events> findAll();

    List<Events> findAllAvailableDatesGivenEvent(int id);

    Events createEvent(Events event); 
}
