package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Timeblock;

import java.util.List;

public interface TimeblockDAO {
    void save(Timeblock timeblock);

    Timeblock findById(Integer id);

    List<Timeblock> findAll();
}
