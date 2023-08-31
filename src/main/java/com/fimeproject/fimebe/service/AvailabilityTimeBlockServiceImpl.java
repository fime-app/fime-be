package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.AvailabilityTimeblockDAO;
import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityTimeBlockServiceImpl implements AvailabilityTimeBlockService {
    private AvailabilityTimeblockDAO availabilityTimeblockDAO;

    public AvailabilityTimeBlockServiceImpl(AvailabilityTimeblockDAO availabilityTimeblockDAO) { this.availabilityTimeblockDAO = availabilityTimeblockDAO;}

    @Override
    public List<AvailabilityTimeBlock> findTimeBlockByAvailabilityId(int availabilityId) {
        return availabilityTimeblockDAO.findTimeblockByAvailabilityId(availabilityId);
    }
}
