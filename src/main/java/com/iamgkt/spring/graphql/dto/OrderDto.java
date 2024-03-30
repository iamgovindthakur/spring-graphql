package com.iamgkt.spring.graphql.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Value;

/** DTO for {@link com.iamgkt.spring.graphql.entity.Order} */
@Value
public class OrderDto implements Serializable {
  long id;
  LocalDateTime created_at;
  String orderDetail;
  String address;
  BigDecimal price;
}
