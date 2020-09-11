package com.rocksea.service.impl;

import com.rocksea.model.User;
import com.rocksea.repository.UserRepository;
import com.rocksea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername( String username ) throws UsernameNotFoundException {
        Optional<User> u = userRepository.findByUsername( username );
        return u.get();
    }

    public User findById( Long id ) throws AccessDeniedException {
        Optional<User> u = userRepository.findById(id);
        return u.get();
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
}
