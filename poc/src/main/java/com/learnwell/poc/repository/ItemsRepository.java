package com.learnwell.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwell.poc.models.Item;

public interface ItemsRepository extends JpaRepository<Item, Long>{

}
