package com.rukon.services;

import com.rukon.dto.OrderDto;
import com.rukon.dto.OrderDto;

import java.util.Collection;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    Collection<OrderDto> findAll();

    OrderDto findById(Long id);

    OrderDto saveOrUpdate(OrderDto orderDto, long id);


}
