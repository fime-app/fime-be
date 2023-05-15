package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Timeblock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Timeblock findById(Integer id) {
        return entityManager.find(Timeblock.class, id);
    }

    @Override
    public List<Timeblock> findAll() {
        // create query
        TypedQuery<Timeblock>  theQuery = entityManager.createQuery("FROM Timeblock", Timeblock.class);
        // return query results
        return theQuery.getResultList();
    }


}
