package com.rocksea.service;

import com.rocksea.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
