package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.AvailabilityTimeBlockDAO;
import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityTimeBlockServiceImpl implements AvailabilityTimeBlockService {
    private AvailabilityTimeBlockDAO availabilityTimeblockDAO;

    public AvailabilityTimeBlockServiceImpl(AvailabilityTimeBlockDAO availabilityTimeblockDAO) { this.availabilityTimeblockDAO = availabilityTimeblockDAO;}

    @Override
    public List<AvailabilityTimeBlock> findTimeBlockByAvailabilityId(int availabilityId) {
        return availabilityTimeblockDAO.findTimeBlockByAvailabilityId(availabilityId);
    }

    @Override
    public AvailabilityTimeBlock createAvailabilityTimeBlock(AvailabilityTimeBlock availabilityTimeBlock) {
        return availabilityTimeblockDAO.save(availabilityTimeBlock);
    }
}
