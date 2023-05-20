package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.TimeblockDAO;
import com.fimeproject.fimebe.dao.TimeblockDAOImpl;
import com.fimeproject.fimebe.entity.Timeblock;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeblockServiceImpl implements TimeblockService {

    private TimeblockDAO timeblockDAO;

    public TimeblockServiceImpl(TimeblockDAO theTimeblockDAO) {
        timeblockDAO = theTimeblockDAO;
    }

    @Override
    public List<Timeblock> findAll() {
        return timeblockDAO.findAll();
    }

    @Override
    public List<Timeblock> findByName(String theName) {
        return timeblockDAO.findByName(theName);
    }

    @Transactional
    @Override
    public Timeblock save(Timeblock theTimeblock) {
        return timeblockDAO.save(theTimeblock);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        timeblockDAO.deleteById(theId);
    }
}
