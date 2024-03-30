package com.iamgkt.spring.graphql.services;

import com.iamgkt.spring.graphql.dto.OrderDto;
import com.iamgkt.spring.graphql.entity.Order;
import com.iamgkt.spring.graphql.exception.OrderNotFoundException;
import com.iamgkt.spring.graphql.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;

  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  public OrderDto findOrderById(long orderId) {
    Order order =
        orderRepository
            .findById(orderId)
            .orElseThrow(() -> OrderNotFoundException.forOrderId(orderId));
    return modelMapper.map(order, OrderDto.class);
  }

  public List<OrderDto> findAllOrder() {
    return orderRepository.findAll().stream()
        .map(order -> modelMapper.map(order, OrderDto.class))
        .collect(Collectors.toList());
  }

  public boolean deleteOrderById(long orderId) {

    Optional<Order> fetchedOrder = orderRepository.findById(orderId);
    if (fetchedOrder.isPresent()) {
      orderRepository.deleteById(orderId);
      return true;
    }
    return false;
  }

  public OrderDto findOrderByUserId(long userId) {
    return modelMapper.map(
        orderRepository
            .findByUserId(userId)
            .orElseThrow(() -> OrderNotFoundException.forUserId(userId)),
        OrderDto.class);
  }
}
