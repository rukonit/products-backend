package com.rukon.services;

import com.rukon.dto.ProductDto;

import java.util.Collection;
import java.util.Optional;

public interface ProductService<T> {
    Collection<T> findAll();

    Collection<ProductDto> findAllProducts();

    Optional<T> findById(Long id);

    T saveOrUpdate(T t);

    String deleteById(Long id);
}
