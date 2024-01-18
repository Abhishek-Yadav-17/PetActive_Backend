package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petServer.PetActive.entities.AdminData;

public interface AdminDao extends JpaRepository<AdminData, String> {
}
