package com.rukon.services.product.impl;

import com.rukon.dto.product.CategoryDto;
import com.rukon.exception.ResourceNotFoundException;
import com.rukon.model.product.Category;
import com.rukon.repository.product.CategoryRepository;
import com.rukon.services.product.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto productDto) {

        Category category = mapToEntity(productDto);

        Category newCategory = categoryRepository.save(category);

        return mapToDto(newCategory);
    }

    @Override
    public Collection<CategoryDto> findAll() {
        List<Category> products = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = products.stream().map(
                post -> mapToDto(post)
        ).collect(Collectors.toList());

        return categoryDtos;
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category", "id", id));
        CategoryDto productDto = mapToDto(category);
        return productDto;
    }

    @Override
    public Category findByCategory(String category) {
        return categoryRepository.findByCategory(category);
    }

    @Override
    public CategoryDto saveOrUpdate(CategoryDto categoryDto, long id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));

        category.setCategory(categoryDto.getCategory());


        Category updatedCategory = categoryRepository.saveAndFlush(category);

        return mapToDto(updatedCategory);
    }

    @Override
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));

        categoryRepository.deleteById(id);

    }

    private CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto= new CategoryDto();
        modelMapper.map(category, categoryDto);
        return categoryDto;
    }

    private Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        modelMapper.map(categoryDto, category);
        return category;
    }
}
