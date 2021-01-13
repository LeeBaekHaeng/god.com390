package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerPagingAndSortingRepository extends PagingAndSortingRepository<Customer, Long> {
}
