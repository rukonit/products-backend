package com.rukon.resources;

import com.rukon.dto.UserDto;
import com.rukon.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

public interface UserResouces<T> {
    @GetMapping
    ResponseEntity<Collection<T>> findAll();

    @GetMapping("{id}")
    ResponseEntity<T>findById(Long id);
}
