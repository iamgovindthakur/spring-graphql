package com.iamgkt.spring.graphql.repository;

import com.iamgkt.spring.graphql.entity.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findByUserId(long userId);
}
