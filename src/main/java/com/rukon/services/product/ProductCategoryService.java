package com.rukon.services.product;

import com.rukon.dto.product.CategoryDto;
import com.rukon.model.product.Category;

import java.util.Collection;

public interface ProductCategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    Collection<CategoryDto> findAll();

    CategoryDto findById(Long id);

    Category findByCategory(String category);

    CategoryDto saveOrUpdate(CategoryDto categoryDto, long id);

    void deleteById(Long id);
}
