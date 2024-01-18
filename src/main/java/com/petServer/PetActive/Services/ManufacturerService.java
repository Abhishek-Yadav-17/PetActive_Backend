package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.ManufacturerDAO;
import com.petServer.PetActive.entities.ManufacturerData;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerDAO mDao;

	public List<ManufacturerData> getManufacturers() {
		return mDao.findAll();
	}

	public Optional<ManufacturerData> getSpecificManufacturer(String id) {
		Optional<ManufacturerData> u = mDao.findById(id);
		return u;
	}

	public ManufacturerData getUpdatedManufacturer(ManufacturerData md) {
		ManufacturerData m = md;
		mDao.save(m);
		return m;
	}

	public ManufacturerData getAddedManufacturer(ManufacturerData md) {
		ManufacturerData m = md;
		mDao.save(m);
		return m;
	}

	public void deleteManufacturer(String id) {
		mDao.deleteById(id);
	}

}
