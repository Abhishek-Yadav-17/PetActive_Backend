package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.ManufacturerData;

public interface ManufacturerDAO extends JpaRepository<ManufacturerData, String> {

}
