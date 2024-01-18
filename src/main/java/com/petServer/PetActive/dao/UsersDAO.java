package com.petServer.PetActive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petServer.PetActive.entities.UserData;

public interface UsersDAO extends JpaRepository<UserData, String> {

}
