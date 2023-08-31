package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;

import java.util.List;

public interface AvailabilityTimeblockDAO {
    List<AvailabilityTimeBlock> findTimeblockByAvailabilityId(int availabilityId);
}
