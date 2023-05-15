package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Timeblock;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TimeblockDAOImpl implements TimeblockDAO{
    private EntityManager entityManager;

    @Autowired
    public TimeblockDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Timeblock timeblock) {
        entityManager.persist(timeblock);
    }
}
