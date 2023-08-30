package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.EventsTimeBlock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventsTimeBlockDAOImpl implements EventsTimeBlockDAO{

    private EntityManager entityManager;

    @Autowired
    public EventsTimeBlockDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EventsTimeBlock> findAll() {
        TypedQuery<EventsTimeBlock> theQuery = entityManager.createQuery("FROM EventsTimeBlock", EventsTimeBlock.class);

        return theQuery.getResultList();
    }

    @Override
    public List<EventsTimeBlock> findById(int id) {
        Query query = entityManager.createQuery("FROM EventsTimeBlock etb " + "where etb.eventId=:id").setParameter("id", id);

        return query.getResultList();
    }

    @Override
    @Transactional
    public EventsTimeBlock save(EventsTimeBlock eventsTimeBlock) {
        EventsTimeBlock dbEventsTimeBlock = entityManager.merge(eventsTimeBlock);

        return dbEventsTimeBlock;
    }
}
