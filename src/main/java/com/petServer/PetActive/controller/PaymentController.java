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

import com.petServer.PetActive.Services.PaymentService;
import com.petServer.PetActive.entities.PaymentData;


@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService PaymentService;

	@GetMapping("/Payments")
	public List<PaymentData> getPaymentData() {
		return PaymentService.getPayments();
	}

	@GetMapping("/Payments/{id}")
	public Optional<PaymentData> getAccessory(@PathVariable long id) {
		return PaymentService.getSpecificPayment(id);
	}

	@PostMapping("/Payments")
	public PaymentData addAcs(@RequestBody PaymentData ud) {
		return PaymentService.getAddedPayment(ud);
	}

	@PutMapping("/Payments")
	public PaymentData updateAcs(@RequestBody PaymentData ud) {
		return PaymentService.getUpdatedPayment(ud);
	}

	@DeleteMapping("/Payments/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			PaymentService.deletePayment(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
