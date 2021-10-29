package com.rukon.services;

import com.rukon.dto.product.ProductDto;

import java.util.Collection;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    Collection<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto saveOrUpdate(ProductDto productDto, long id);

    void deleteById(Long id);
}
