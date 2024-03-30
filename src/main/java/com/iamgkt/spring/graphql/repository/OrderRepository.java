package com.iamgkt.spring.graphql.repository;

import com.iamgkt.spring.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {}
