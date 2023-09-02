package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.AvailabilityDAO;
import com.fimeproject.fimebe.entity.Availability;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
    private AvailabilityDAO availabilityDAO;

    public AvailabilityServiceImpl(AvailabilityDAO availabilityDAO) { this.availabilityDAO = availabilityDAO; }
    @Override
    public List<Availability> findByEventId(int eventId) {
        return availabilityDAO.findByEventId(eventId);
    }

    @Override
    public Availability createAvailability(Availability availability) {
        return availabilityDAO.save(availability);
    }
}
