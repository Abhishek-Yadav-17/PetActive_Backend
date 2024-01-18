package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.Accessories;

public interface AcsDAO extends JpaRepository<Accessories, Long> {

}
