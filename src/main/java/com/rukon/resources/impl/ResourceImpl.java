package com.rukon.resources.impl;

import com.rukon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rukon.resources.Resource;
import com.rukon.services.ProductService;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ResourceImpl implements Resource<Product> {

    @Autowired
    private ProductService<Product> productService;

    @Override
    public ResponseEntity<Collection<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<Product> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> save(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Product> update(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Product> deleteById(long id) {
        return null;
    }

    @Override
    public RequestEntity<String> invalid() {
        return null;
    }
}
