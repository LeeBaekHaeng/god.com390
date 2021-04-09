package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.CmmnCode;

public interface CmmnCodeRepository extends JpaRepository<CmmnCode, String>, JpaSpecificationExecutor<CmmnCode> {

}
