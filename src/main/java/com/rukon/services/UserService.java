package com.rukon.services;

import java.util.Collection;
import java.util.Optional;

public interface UserService<T> {

    Collection<T> findAll();

    Optional<T> findbyId(Long Id);

    T saveOrUpdate(T t);

    String deleteById(Long id);
}
