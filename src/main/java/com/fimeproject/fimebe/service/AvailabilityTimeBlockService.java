package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;

import java.util.List;

public interface AvailabilityTimeBlockService {
    List<AvailabilityTimeBlock> findTimeBlockByAvailabilityId(int availabilityId);
}
