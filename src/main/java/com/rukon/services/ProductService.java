package com.rukon.services;

import com.rukon.models.P;
import com.rukon.models.Product;

import javax.persistence.Column;
import java.util.Collection;
import java.util.Optional;

public interface ProductService<T> {
    Collection<T> findAll();

    Collection<P> findAllProducts();

    Optional<T> findById(Long id);

    T saveOrUpdate(T t);

    String deleteById(Long id);
}
