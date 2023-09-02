package com.fimeproject.fimebe.service;

import com.fimeproject.fimebe.dao.UsersDAO;
import com.fimeproject.fimebe.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    private UsersDAO usersDAO;

    public UsersServiceImpl(UsersDAO usersDAO) { this.usersDAO = usersDAO; }
    @Override
    public List<Users> findUser(String username) {
        return usersDAO.findByUsername(username);
    }
}
