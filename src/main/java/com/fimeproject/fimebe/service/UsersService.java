package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> findUser(String username);
}
