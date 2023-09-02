package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvailabilityTimeBlockDAOImpl implements AvailabilityTimeBlockDAO {
    private EntityManager entityManager;

    @Autowired
    public AvailabilityTimeBlockDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

    @Override
    public List<AvailabilityTimeBlock> findTimeBlockByAvailabilityId(int availabilityId) {
        Query query = entityManager.createQuery("select at FROM AvailabilityTimeBlock at " + "WHERE availabilityId=:availabilityId").setParameter("availabilityId", availabilityId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public AvailabilityTimeBlock save(AvailabilityTimeBlock availabilityTimeBlock) {
        return entityManager.merge(availabilityTimeBlock);
    }
}
