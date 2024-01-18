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

import com.petServer.PetActive.Services.OrderService;
import com.petServer.PetActive.entities.OrderData;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService OrderService;

	@GetMapping("/Orders")
	public List<OrderData> getOrderData() {
		return OrderService.getOrders();
	}

	@GetMapping("/Orders/{id}")
	public Optional<OrderData> getAccessory(@PathVariable Long id) {
		return OrderService.getSpecificOrder(id);
	}

	@PostMapping("/Orders")
	public OrderData addAcs(@RequestBody OrderData ud) {
		return OrderService.getAddedOrder(ud);
	}

	@PutMapping("/Orders")
	public OrderData updateAcs(@RequestBody OrderData ud) {
		return OrderService.getUpdatedOrder(ud);
	}

	@DeleteMapping("/Orders/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			OrderService.deleteOrder(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
