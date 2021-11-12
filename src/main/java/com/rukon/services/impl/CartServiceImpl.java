package com.rukon.services.impl;

import com.rukon.dto.CartDto;
import com.rukon.dto.CartRequest;
import com.rukon.exception.ResourceNotFoundException;
import com.rukon.model.Cart;
import com.rukon.model.User;
import com.rukon.model.product.Product;
import com.rukon.repository.CartRepository;
import com.rukon.repository.UserRepository;
import com.rukon.repository.product.ProductRepository;
import com.rukon.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartDto findbyId(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", id));
        CartDto cartDto = mapToDto(cart);
        return cartDto;
    }

    @Override
    public CartDto saveOrUpdate(CartRequest cartRequest, long id) {

        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cart", "id", id));
        
        Cart updatedCart = cartRepository.saveAndFlush(cart);

        return mapToDto(updatedCart);
    }

    @Override
    public void deleteById(Long id) {
       Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cart", "id", id));
       cartRepository.deleteById(id);
    }

    @Override
    public CartDto addToCart(CartRequest cartRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        Product product = productRepository.findById(cartRequest.getProductId()).orElseThrow(()-> new ResourceNotFoundException("product", "id", cartRequest.getProductId()));
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(cartRequest.getQuantity());
        cart.setUser(user);
        Cart newCart = cartRepository.save(cart);
        return mapToDto(newCart);
    }

    @Override
    public Set<CartDto> findAllByUser(long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        System.out.println(user);
        Set<Cart> carts = cartRepository.findAllByUserId(userId);

        Set<CartDto> cartDtos = carts.stream().map(
                cart -> mapToDto(cart)
        ).collect(Collectors.toSet());
        System.out.println(cartDtos);
        return cartDtos;
    }

    private CartDto mapToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        modelMapper.map(cart, cartDto);
        cartDto.setUserId(cart.getUser().getId());
        return cartDto;
    }

    private Cart mapToEntity(CartDto cartDto) {
        Cart cart = new Cart();

        cart.setProduct(cartDto.getProduct());
        cart.setQuantity(cartDto.getQuantity());
        User user = userRepository.findById((long)cartDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("user", "id", cartDto.getUserId()));
        cart.setUser(user);
        return cart;
    }
    }

