package com.rukon.resources.impl;

import com.rukon.dto.UserDto;
import com.rukon.mapper.UserDtoMapper;
import com.rukon.models.Cart;
import com.rukon.models.Product;
import com.rukon.models.User;
import com.rukon.resources.UserResouces;
import com.rukon.services.CartService;
import com.rukon.services.ProductService;
import com.rukon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Transactional
public class UserResourceImpl implements UserResouces {

    @Autowired
    private UserService<User> userService;

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @Override
    public ResponseEntity<Collection> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        System.out.println(id);
        return new ResponseEntity(userService.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("auser")
    @Transactional
    public ResponseEntity<UserDto> findById(@RequestParam String userName) {
        long id = 149;

        return new ResponseEntity(userService.findbyUserName(userName).map(userDtoMapper::map).orElseThrow(), HttpStatus.OK);
    }

//    @PostMapping("addProductToCart")
//    public ResponseEntity<UserDto> addProductToCart(@RequestParam String userName, @RequestParam long productId) {
//
//        Cart cart = new Cart();
//        User user = userService.findbyUserName(userName).get();
//        cart.setUser(user);
//        cart.getProducts().add((Product) productService.findById(productId).get());
//        cartService.saveOrUpdate(cart);
//
//        return new ResponseEntity(userService.findbyUserName(userName).map(userDtoMapper::map).orElseThrow(), HttpStatus.OK);
//    }



}
