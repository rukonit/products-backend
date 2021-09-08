package com.rukon.resources;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public interface ProductResource<T> {
    @GetMapping
    ResponseEntity<Collection<T>> findAll();

    @GetMapping("{id}")
    ResponseEntity<T> findById(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<T> save(@RequestBody T t);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<T> update(@RequestBody T t);

    @DeleteMapping("{id}")
    ResponseEntity<T> deleteById(@PathVariable long id);

    @GetMapping("/invalid")
    RequestEntity<String> invalid();
}
