package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.CmmnClCode;

public interface CmmnClCodeRepository extends JpaRepository<CmmnClCode, String>, JpaSpecificationExecutor<CmmnClCode> {

}
