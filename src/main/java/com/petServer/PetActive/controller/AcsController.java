package com.petServer.PetActive.controller;

import java.util.List;
import java.util.Set;

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

import com.petServer.PetActive.Services.AcsService;
import com.petServer.PetActive.entities.Accessories;

// REST: REpresentation of State Transfer
@RestController
public class AcsController {

	@Autowired
	private AcsService acsServ;

//	Get the Accessories

	@GetMapping("/accessories")
//	@RequestMapping(path = "/accessories", method= RequestMethod.GET) // Both are same
	public List<Accessories> getAccessories() {
		return acsServ.getAccessories();
	}
	
	@GetMapping("/accessories/categories")
	public Set<String> getcat(){
		return acsServ.getCate();
	}

	@GetMapping("/accessories/{category}")
	public List<Accessories> getAccessory(@PathVariable String category) {
		return acsServ.getSpecificAccessories(category);
	}

//	@PostMapping(path = "/accessories", consumes = "application/json")
	@PostMapping("/accessories")
	public Accessories addAcs(@RequestBody Accessories acc) {
		return acsServ.getAddedAcs(acc);
	}

	@PutMapping("/accessories")
	public Accessories updateAcs(@RequestBody Accessories acc) {
		return acsServ.getUpdatedAcs(acc);
	}

	@DeleteMapping("/accessories/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			acsServ.getDeletedAccessories(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
