package com.sarat.practice.springbootcurd.repository;

import com.sarat.practice.springbootcurd.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJPARepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
