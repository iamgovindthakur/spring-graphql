package com.iamgkt.spring.graphql.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class OrderNotFoundException extends RuntimeException {
  private final String message;

  public static OrderNotFoundException forUserId(long userId) {
    return of("Order Not Found With User ID: " + userId);
  }

  public static OrderNotFoundException forOrderId(long orderId) {
    return of("Order Not Found With Order ID: " + orderId);
  }
}
