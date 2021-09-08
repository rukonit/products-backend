package com.rukon.services.impl;

import com.rukon.dto.UserDto;
import com.rukon.models.User;
import com.rukon.repository.UserRepository;
import com.rukon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findbyId(Long Id) {
        return userRepository.findById(Id);
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }


}
