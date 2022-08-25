package com.learnwell.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwell.poc.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
