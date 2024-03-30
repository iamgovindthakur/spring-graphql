package com.iamgkt.spring.graphql.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UserNotFoundException extends RuntimeException {

  private final String message;

  public static UserNotFoundException forUserId(long userId) {
    return of("User Not Found With User ID: " + userId);
  }
}
