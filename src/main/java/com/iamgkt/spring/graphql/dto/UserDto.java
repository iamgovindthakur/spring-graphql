package com.iamgkt.spring.graphql.dto;

import lombok.*;

/** DTO for {@link com.iamgkt.spring.graphql.entity.User} */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDto {
  private long id;
  private String name;
  private String email;
  private String password;
}
