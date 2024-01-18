package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.CartItemData;

public interface CartItemDAO extends JpaRepository<CartItemData,Long> {

}
