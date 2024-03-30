package com.iamgkt.spring.graphql.controller;

import com.iamgkt.spring.graphql.dto.OrderDto;
import com.iamgkt.spring.graphql.dto.UserDto;
import com.iamgkt.spring.graphql.entity.Order;
import com.iamgkt.spring.graphql.entity.User;
import com.iamgkt.spring.graphql.services.OrderService;
import com.iamgkt.spring.graphql.services.UserService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;
  private final UserService userService;
  private final ModelMapper modelMapper;

  private static Order buildOrder(String orderDetail, String address, BigDecimal price, User user) {
    return Order.builder()
        .orderDetail(orderDetail)
        .address(address)
        .price(price)
        .user(user)
        .created_at(LocalDateTime.now())
        .build();
  }

  @MutationMapping
  public Order createOrder(
      @Argument String orderDetail,
      @Argument String address,
      @Argument BigDecimal price,
      @Argument long userId) {

    UserDto fetchedUserById = userService.findUserById(userId);
    User user = modelMapper.map(fetchedUserById, User.class);
    return orderService.createOrder(buildOrder(orderDetail, address, price, user));
  }

  @QueryMapping
  public OrderDto getOrder(@Argument long id) {
    return orderService.findOrderById(id);
  }

  @QueryMapping
  public List<OrderDto> getOrders() {
    return orderService.findAllOrder();
  }

  @MutationMapping
  public boolean deleteOrder(@Argument long id) {
    return orderService.deleteOrderById(id);
  }
}
