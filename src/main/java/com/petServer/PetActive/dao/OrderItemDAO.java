package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.OrderItemData;

public interface OrderItemDAO extends JpaRepository<OrderItemData, Long> {

}
