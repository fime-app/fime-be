package com.fimeproject.fimebe.dao;

import com.fimeproject.fimebe.entity.Users;

import java.util.List;

public interface UsersDAO {
    List<Users> findByUsername(String username);

    Users save(Users user);
}
