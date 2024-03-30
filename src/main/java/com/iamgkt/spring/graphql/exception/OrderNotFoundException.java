package com.iamgkt.spring.graphql.exception;public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forUserId(long userId) {
        return new OrderNotFoundException("Order Not Found With User ID: " + userId);
    }
}
