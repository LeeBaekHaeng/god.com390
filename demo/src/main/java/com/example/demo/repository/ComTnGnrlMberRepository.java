package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.ComTnGnrlMber;

public interface ComTnGnrlMberRepository
		extends JpaRepository<ComTnGnrlMber, String>, JpaSpecificationExecutor<ComTnGnrlMber> {

}
