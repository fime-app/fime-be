package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.Availability;

import java.util.List;

public interface AvailabilityService {
    List<Availability> findByEventId(int id);
}
