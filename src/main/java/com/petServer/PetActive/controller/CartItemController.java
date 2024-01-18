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

import com.petServer.PetActive.Services.CartItemService;
import com.petServer.PetActive.entities.CartItemData;

@RestController
public class CartItemController {
	
	@Autowired
	private CartItemService CartItemservice;

	@GetMapping("/CartItems")
	public List<CartItemData> getCartData() {
		return CartItemservice.getCartItems();
	}

	@GetMapping("/CartItems/{cart_id}")
	public List<CartItemData> getAccessory(@PathVariable long cart_id) {
		return CartItemservice.getSpecificCartItem(cart_id);
	}

	@PostMapping("/CartItems")
	public CartItemData addAcs(@RequestBody CartItemData ud) {
		return CartItemservice.getAddedCartItem(ud);
	}

	@PutMapping("/CartItems")
	public CartItemData updateAcs(@RequestBody CartItemData ud) {
		return CartItemservice.getUpdatedCartItem(ud);
	}

	@DeleteMapping("/CartItems/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			CartItemservice.deleteCartItem(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
