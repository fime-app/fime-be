package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Events;

import java.util.List;

public interface EventsDAO {
    List<Events> findAll();

    List<Events> findById(int id);

}
