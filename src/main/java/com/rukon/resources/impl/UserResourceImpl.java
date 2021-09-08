package com.rukon.resources.impl;

import com.rukon.dto.UserDto;
import com.rukon.models.User;
import com.rukon.resources.UserResouces;
import com.rukon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Transactional
public class UserResourceImpl implements UserResouces {

    @Autowired
    private UserService<User> userService;


    @Override
    public ResponseEntity<Collection> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        System.out.println(id);
        return new ResponseEntity(userService.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("auser")
    public ResponseEntity<UserDto> findById(@RequestParam String userName) {
        System.out.println(userName);
        return new ResponseEntity(userService.findAUser(userName), HttpStatus.OK);
    }



}
