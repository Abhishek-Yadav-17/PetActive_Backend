package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.petServer.PetActive.entities.Accessories;

public interface AcsService {
	
	public List<Accessories> getAccessories();

	public List<Accessories> getSpecificAccessories(String name);
//	public Accessories getSpecificAccessories(int id);

	public Accessories getAddedAcs(Accessories acc);

	public Accessories getUpdatedAcs(Accessories acc);

	public void getDeletedAccessories(long id);

	public Optional<Accessories> getSpecificAcsId(Long id);

	public Set<String> getCate();

}
