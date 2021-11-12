package com.rukon.controller;

import com.rukon.dto.Message;
import com.rukon.dto.product.ProductDto;
import com.rukon.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/v1/products")
    private ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
    return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/products")
    private ResponseEntity<Collection<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/api/v1/products/{id}")
    private  ResponseEntity<ProductDto> findById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping(value = "/api/v1/products/{id}")
    private  ResponseEntity<ProductDto> findById(@RequestBody ProductDto productDto, @PathVariable(name = "id") long id){
        return ResponseEntity.ok(productService.saveOrUpdate(productDto, id));
    }

    @DeleteMapping(value = "/api/v1/products/{id}")
    private  ResponseEntity<Message> deleteById(@PathVariable(name = "id") long id){
        productService.deleteById(id);
        return ResponseEntity.ok(new Message("Successfully deleted the product"));
    }
}
