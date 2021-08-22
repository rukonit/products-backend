package com.rukon.services;

import java.util.Collection;
import java.util.Optional;

public interface ProductService<T> {
    Collection<T> findAll();

    Optional<T> findById(Long id);

    T saveOrUpdate(T t);

    String deleteById(Long id);
}
