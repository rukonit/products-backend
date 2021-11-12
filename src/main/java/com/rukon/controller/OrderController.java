package com.rukon.controller;

import com.rukon.dto.OrderDto;
import com.rukon.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/v1/orders")
    private ResponseEntity<OrderDto> createProduct(@RequestBody OrderDto productDto){
    return new ResponseEntity<>(orderService.createOrder(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/orders")
    private ResponseEntity<Collection<OrderDto>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/api/v1/orders/{id}")
    private  ResponseEntity<OrderDto> findById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PutMapping(value = "/api/v1/orders/{id}")
    private  ResponseEntity<OrderDto> findById(@RequestBody OrderDto productDto, @PathVariable(name = "id") long id){
        return ResponseEntity.ok(orderService.saveOrUpdate(productDto, id));
    }

  }
