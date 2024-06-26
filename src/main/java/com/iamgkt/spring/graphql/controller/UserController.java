package com.iamgkt.spring.graphql.controller;

import com.iamgkt.spring.graphql.dto.UserDto;
import com.iamgkt.spring.graphql.entity.User;
import com.iamgkt.spring.graphql.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  private static User buildUser(String name, String email, String password) {
    return User.builder().name(name).email(email).password(password).build();
  }

  @MutationMapping
  public User createUser(@Argument String name, @Argument String email, @Argument String password) {
    return userService.createUser(buildUser(name, email, password));
  }

  @QueryMapping
  public UserDto getUser(@Argument long id) {
    return userService.findUserById(id);
  }

  @QueryMapping
  public List<UserDto> getUsers() {
    return userService.getAllUser();
  }

  @MutationMapping
  public boolean deleteUser(@Argument long id) {
    return userService.deleteUserById(id);
  }
}
