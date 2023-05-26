package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Events;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventsDAOImpl implements EventsDAO{

    private EntityManager entityManager;

    @Autowired
    public EventsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Events> findAll() {
        TypedQuery<Events> theQuery = entityManager.createQuery("FROM Events", Events.class);

        return theQuery.getResultList();
    }
}
