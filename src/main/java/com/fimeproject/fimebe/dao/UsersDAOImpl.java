package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO{

    private EntityManager entityManager;

    @Autowired
    public UsersDAOImpl(EntityManager entityManager) {this.entityManager = entityManager; }

    @Override
    public List<Users> findByUsername(String username) {
        Query query = entityManager.createQuery("FROM Users u " + "WHERE u.username=:username").setParameter("username", username);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Users save(Users user) {
        return entityManager.merge(user);
    }
}
