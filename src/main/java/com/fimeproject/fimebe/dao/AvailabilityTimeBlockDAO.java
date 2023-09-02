package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;

import java.util.List;

public interface AvailabilityTimeBlockDAO {
    List<AvailabilityTimeBlock> findTimeBlockByAvailabilityId(int availabilityId);

    AvailabilityTimeBlock save(AvailabilityTimeBlock availabilityTimeBlock);
}
