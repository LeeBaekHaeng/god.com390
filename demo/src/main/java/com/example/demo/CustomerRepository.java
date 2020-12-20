package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//public interface CustomerRepository extends CrudRepository<Customer, Long> {
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);

}
