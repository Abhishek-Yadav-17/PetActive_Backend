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

import com.petServer.PetActive.Services.OrderItemService;
import com.petServer.PetActive.entities.OrderItemData;


@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService OrderItemService;

	@GetMapping("/OrderItems")
	public List<OrderItemData> getOrderItemData() {
		return OrderItemService.getOrderItems();
	}

	@GetMapping("/OrderItems/{id}")
	public Optional<OrderItemData> getAccessory(@PathVariable long id) {
		return OrderItemService.getSpecificOrderItem(id);
	}

	@PostMapping("/OrderItems")
	public OrderItemData addAcs(@RequestBody OrderItemData ud) {
		return OrderItemService.getAddedOrderItem(ud);
	}

	@PutMapping("/OrderItems")
	public OrderItemData updateAcs(@RequestBody OrderItemData ud) {
		return OrderItemService.getUpdatedOrderItem(ud);
	}

	@DeleteMapping("/OrderItems/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			OrderItemService.deleteOrderItem(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
