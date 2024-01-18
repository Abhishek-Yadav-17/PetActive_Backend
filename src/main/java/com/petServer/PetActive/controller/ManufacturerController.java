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

import com.petServer.PetActive.Services.ManufacturerService;
import com.petServer.PetActive.entities.ManufacturerData;


@RestController
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService ManufacturerService;

	@GetMapping("/Manufacturers")
	public List<ManufacturerData> getManufacturerData() {
		return ManufacturerService.getManufacturers();
	}

	@GetMapping("/Manufacturers/{id}")
	public Optional<ManufacturerData> getAccessory(@PathVariable String id) {
		return ManufacturerService.getSpecificManufacturer(id);
	}

	@PostMapping("/Manufacturers")
	public ManufacturerData addAcs(@RequestBody ManufacturerData ud) {
		return ManufacturerService.getAddedManufacturer(ud);
	}

	@PutMapping("/Manufacturers")
	public ManufacturerData updateAcs(@RequestBody ManufacturerData ud) {
		return ManufacturerService.getUpdatedManufacturer(ud);
	}

	@DeleteMapping("/Manufacturers/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			ManufacturerService.deleteManufacturer(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
