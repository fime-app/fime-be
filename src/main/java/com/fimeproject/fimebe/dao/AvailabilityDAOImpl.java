package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Availability;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvailabilityDAOImpl implements AvailabilityDAO {
    private EntityManager entityManager;

    @Autowired
    public AvailabilityDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }
    @Override
    public List<Availability> findByEventId(int eventId) {
        Query query = entityManager.createQuery("select e FROM Availability e " + "WHERE eventId=:eventId").setParameter("eventId", eventId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Availability save(Availability availability) {
        return entityManager.merge(availability);
    }


}
