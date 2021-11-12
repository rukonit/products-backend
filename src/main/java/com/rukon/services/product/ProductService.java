package com.rukon.services.product;

import com.rukon.dto.product.ProductDto;
import com.rukon.dto.product.SideDto;
import com.rukon.model.product.Side;

import java.util.Collection;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    Collection<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto saveOrUpdate(ProductDto productDto, long id);

    void deleteById(Long id);


}
