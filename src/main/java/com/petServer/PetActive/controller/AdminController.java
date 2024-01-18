package com.petServer.PetActive.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petServer.PetActive.Services.AdminService;
import com.petServer.PetActive.entities.AdminData;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService AdminService;

	@GetMapping("/Admins")
	public List<AdminData> getAdminData() {
		return AdminService.getAdmins();
	}

	@GetMapping("/Admins/{id}")
	public Optional<AdminData> getAccessory(@PathVariable String id) {
		return AdminService.getSpecificAdmin(id);
	}

	@PostMapping("/Admins")
	public AdminData addAcs(@RequestBody AdminData ud) {
		return AdminService.getAddedAdmin(ud);
	}

	@PutMapping("/Admins")
	public AdminData updateAcs(@RequestBody AdminData ud) {
		return AdminService.getUpdatedAdmin(ud);
	}

	@DeleteMapping("/Admins/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			AdminService.deleteAdmin(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
