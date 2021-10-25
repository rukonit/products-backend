package com.rukon.controller;

import com.rukon.dto.ProductDto;
import com.rukon.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/v1/products")
    private ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
    return new ResponseEntity<>(productService.saveOrUpdate(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/products")
    private ResponseEntity<Collection<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}
