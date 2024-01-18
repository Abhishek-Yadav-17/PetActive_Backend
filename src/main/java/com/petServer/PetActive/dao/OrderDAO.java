package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.OrderData;

public interface OrderDAO extends JpaRepository<OrderData, Long> {

}
