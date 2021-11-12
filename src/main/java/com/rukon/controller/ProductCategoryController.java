package com.rukon.controller;

import com.rukon.dto.Message;
import com.rukon.dto.product.CategoryDto;
import com.rukon.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    @PostMapping("/api/v1/products/category")
    private ResponseEntity<CategoryDto> createProduct(@RequestBody CategoryDto categoryDto){
    return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/products/category")
    private ResponseEntity<Collection<CategoryDto>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/api/v1/products/category/{id}")
    private  ResponseEntity<CategoryDto> findById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping(value = "/api/v1/products/category/{id}")
    private  ResponseEntity<CategoryDto> findById(@RequestBody CategoryDto categoryDto, @PathVariable(name = "id") long id){
        return ResponseEntity.ok(categoryService.saveOrUpdate(categoryDto, id));
    }

    @DeleteMapping(value = "/api/v1/products/category/{id}")
    private  ResponseEntity<Message> deleteById(@PathVariable(name = "id") long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok(new Message("Successfully deleted the category"));
    }
}
