package com.rukon.services;

import com.rukon.dto.CartDto;
import com.rukon.dto.CartRequest;
import com.rukon.dto.product.ProductDto;
import com.rukon.model.Cart;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface CartService {

    CartDto findbyId(Long Id);

    CartRequest saveOrUpdate(CartRequest cartRequest, Long id);

    void deleteById(Long id);

    CartDto addToCart(CartRequest cartRequest, Long userId);

    Set<CartDto> findAllByUser(long userId);

}
