package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.CartData;

public interface CartDAO extends JpaRepository<CartData, Long> {

}
