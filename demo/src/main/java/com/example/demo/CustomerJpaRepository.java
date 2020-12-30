package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
