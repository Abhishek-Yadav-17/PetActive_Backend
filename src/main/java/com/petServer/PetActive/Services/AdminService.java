package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.AdminDao;
import com.petServer.PetActive.entities.AdminData;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao aDao;

	public List<AdminData> getAdmins() {
		return aDao.findAll();
	}

	public Optional<AdminData> getSpecificAdmin(String id) {
		Optional<AdminData> o = aDao.findById(id);
		return o;
	}

	public AdminData getUpdatedAdmin(AdminData od) {
		AdminData o = od;
		aDao.save(o);
		return o;
	}

	public AdminData getAddedAdmin(AdminData od) {
		AdminData o = od;
		aDao.save(o);
		return o;
	}

	public void deleteAdmin(String id) {
		aDao.deleteById(id);
	}

}