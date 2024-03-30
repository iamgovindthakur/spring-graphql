package com.iamgkt.spring.graphql.services;

import com.iamgkt.spring.graphql.dto.UserDto;
import com.iamgkt.spring.graphql.entity.User;
import com.iamgkt.spring.graphql.exception.UserNotFoundException;
import com.iamgkt.spring.graphql.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public UserDto findUserById(long userId) {
    return modelMapper.map(
        userRepository.findById(userId).orElseThrow(() -> UserNotFoundException.forUserId(userId)),
        UserDto.class);
  }

  public List<UserDto> getAllUser() {

    return userRepository.findAll().stream()
        .map((element) -> modelMapper.map(element, UserDto.class))
        .collect(Collectors.toList());
  }

  public boolean deleteUserById(long userId) {
    Optional<User> fetchedUser = userRepository.findById(userId);

    if (fetchedUser.isPresent()) {
      userRepository.deleteById(userId);
      return true;
    }
    return false;
  }
}
