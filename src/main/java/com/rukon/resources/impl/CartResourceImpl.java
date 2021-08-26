package com.rukon.resources.impl;

import com.rukon.models.Cart;
import com.rukon.models.Product;
import com.rukon.resources.CartResources;
import com.rukon.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartResourceImpl implements CartResources {

    @Autowired
    private CartService<Cart> cartService;

    @Override
    @Transactional
    public ResponseEntity<Collection> findAll() {

        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity findById(Long id) {

        Optional<Cart> cart = cartService.findbyId(id);

        if(!cart.isPresent()) {

        }

        return new ResponseEntity<>(cart.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity save(Object o) {
        return null;
    }

    @Override
    public ResponseEntity update(Object o) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(long id) {
        return null;
    }

    @Override
    public RequestEntity<String> invalid() {
        return null;
    }
}
