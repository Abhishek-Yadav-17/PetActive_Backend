package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.ReviewData;

public interface ReviewDAO extends JpaRepository<ReviewData, Long> {

}
