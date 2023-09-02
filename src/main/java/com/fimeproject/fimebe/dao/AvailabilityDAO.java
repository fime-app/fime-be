package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Availability;

import java.util.List;

public interface AvailabilityDAO {
    List<Availability> findByEventId(int eventId);

    Availability save(Availability availability);
}
