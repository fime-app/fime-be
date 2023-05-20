package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Timeblock;

import java.util.List;

public interface TimeblockDAO {
    Timeblock save(Timeblock timeblock);

    List<Timeblock> findByName(String name);

    List<Timeblock> findAll();

    void deleteById(int theId);
}
