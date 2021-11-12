package com.rukon.controller;

import com.rukon.dto.CartDto;
import com.rukon.dto.CartRequest;
import com.rukon.dto.Message;
import com.rukon.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/api/v1/carts")
    private ResponseEntity<CartDto> createProduct(@RequestBody CartRequest cartRequest, @RequestParam(name = "user") Long userId){
        System.out.println(cartRequest);
        return new ResponseEntity<>(cartService.addToCart(cartRequest, userId), HttpStatus.CREATED);
    }

//    @GetMapping("/api/v1/carts")
//    private ResponseEntity<Collection<CartDto>> findAll(){
//        return ResponseEntity.ok(cartService.findAll());
//    }

    @GetMapping("/api/v1/carts")
    private  ResponseEntity<Set<CartDto>> findAllById(@RequestParam(name = "user") Long id){
        return new ResponseEntity<>(cartService.findAllByUser(id), HttpStatus.OK);
    }

    @PutMapping(value = "/api/v1/carts")
    private  ResponseEntity<CartDto> findById(@RequestBody CartRequest cartRequest, @RequestParam(name = "user") long id){
        return ResponseEntity.ok(cartService.saveOrUpdate(cartRequest, id));
    }

    @DeleteMapping(value = "/api/v1/carts/{id}")
    private  ResponseEntity<Message> deleteById(@PathVariable(name = "id") long id){
        cartService.deleteById(id);
        return ResponseEntity.ok(new Message("Successfully deleted the product"));
    }
}
