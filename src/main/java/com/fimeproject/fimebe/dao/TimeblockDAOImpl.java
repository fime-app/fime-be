package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Timeblock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
    public Timeblock save(Timeblock timeblock) {

        Timeblock dbTimeblock = entityManager.merge(timeblock);

        return dbTimeblock;
    }

    @Override
    public void deleteById(int theId) {
        Timeblock theTimeblock = entityManager.find(Timeblock.class, theId);

        entityManager.remove(theTimeblock);
    }


    @Override
    public List<Timeblock> findByName(String name) {

        Query query = entityManager.createQuery("select tb FROM Timeblock tb " + "where tb.name=:name").setParameter("name", name);

        return query.getResultList();

    }

    @Override
    public List<Timeblock> findAll() {
        // create query
        TypedQuery<Timeblock>  theQuery = entityManager.createQuery("FROM Timeblock", Timeblock.class);
        // return query results
        return theQuery.getResultList();
    }


}
