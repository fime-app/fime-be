package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.Timeblock;

import java.util.List;

public interface TimeblockService {
    List<Timeblock> findAll();

    List<Timeblock> findByName(String theName);

    Timeblock save(Timeblock theTimeblock);

    void deleteById(int theId);

}
