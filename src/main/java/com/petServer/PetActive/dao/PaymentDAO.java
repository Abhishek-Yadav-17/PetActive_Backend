package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.PaymentData;

public interface PaymentDAO extends JpaRepository<PaymentData, Long> {

}
