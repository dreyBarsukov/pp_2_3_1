package com.service;

import com.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updeteUser);

    void delete(long id);
}
