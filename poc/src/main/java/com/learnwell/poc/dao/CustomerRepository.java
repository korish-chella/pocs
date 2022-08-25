package com.learnwell.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwell.poc.dto.Countries;

public interface CustomerRepository extends JpaRepository<Countries, Integer>{

}
