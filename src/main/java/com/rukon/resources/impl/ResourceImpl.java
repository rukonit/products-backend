package com.rukon.resources.impl;

import com.rukon.dto.ProductDto;
import com.rukon.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rukon.resources.Resource;
import com.rukon.services.ProductService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
@Transactional
public class ResourceImpl implements Resource<Product> {

    @Autowired
    private ProductService<Product> productService;

    @Override

    public ResponseEntity<Collection<Product>> findAll() {
        log.info("ProductResourcesImpl - findAll");
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK) ;
    }
    @GetMapping("/justproducts")
    public ResponseEntity<Collection<ProductDto>> findAllProduct() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Product> findById(Long id) {
        log.info("ProductResourcesImpl - findAll");
        Optional<Product> product = productService.findById(id);

        if(!product.isPresent()) {
            log.info("Product not found");
        }

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
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
