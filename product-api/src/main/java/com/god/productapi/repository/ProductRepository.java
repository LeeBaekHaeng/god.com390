package com.god.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.god.productapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
