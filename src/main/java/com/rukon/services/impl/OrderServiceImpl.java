package com.rukon.services.impl;

import com.rukon.dto.OrderDto;
import com.rukon.dto.OrderDto;
import com.rukon.exception.ResourceNotFoundException;
import com.rukon.model.Order;
import com.rukon.repository.OrderRepository;
import com.rukon.repository.OrderRepository;
import com.rukon.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = mapToEntity(orderDto);

        Order newOrder = orderRepository.save(order);

        return mapToDto(newOrder);
    }

    @Override
    public Collection<OrderDto> findAll() {
        List<Order> products = orderRepository.findAll();

        List<OrderDto> orderDtos = products.stream().map(
                post -> mapToDto(post)
        ).collect(Collectors.toList());

        return orderDtos;
    }

    @Override
    public OrderDto findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("order", "id", id));
        OrderDto orderDto = mapToDto(order);
        return orderDto;
    }


    @Override
    public OrderDto saveOrUpdate(OrderDto orderDto, long id) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));
        order.setStatus(orderDto.getStatus());
        Order updatedOrder = orderRepository.saveAndFlush(order);

        return mapToDto(updatedOrder);
    }


    private OrderDto mapToDto(Order order) {
        OrderDto orderDto= new OrderDto();
        modelMapper.map(order, orderDto);
        return orderDto;
    }

    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        modelMapper.map(orderDto, order);
        return order;
    }
}
