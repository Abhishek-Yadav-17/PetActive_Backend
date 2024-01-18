package com.petServer.PetActive.controller;

import java.util.List;

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

import com.petServer.PetActive.Services.CartService;
import com.petServer.PetActive.entities.CartData;

@RestController
public class CartController {
	
	@Autowired
	private CartService cs;
	
	@GetMapping("/carts")
	public List<CartData> getCartData() {
		return cs.getCarts();
	}

	@GetMapping("/carts/{uid}")
	public CartData getAccessory(@PathVariable String uid) {
		return cs.getSpecificCart(uid);
	}

	@PostMapping("/carts")
	public CartData addAcs(@RequestBody CartData ud) {
		return cs.getAddedCart(ud);
	}

	@PutMapping("/carts")
	public CartData updateAcs(@RequestBody CartData ud) {
		return cs.getUpdatedCart(ud);
	}

	@DeleteMapping("/carts/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
