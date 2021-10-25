package com.rukon.services;

import com.rukon.dto.ProductDto;

import java.util.Collection;

public interface ProductService {

    Collection<ProductDto> findAll();


    ProductDto findById(Long id);

    ProductDto saveOrUpdate(ProductDto productDto);

    String deleteById(Long id);
}
