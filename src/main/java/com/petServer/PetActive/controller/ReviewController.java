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

import com.petServer.PetActive.Services.ReviewService;
import com.petServer.PetActive.entities.ReviewData;


@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService ReviewService;

	@GetMapping("/Reviews")
	public List<ReviewData> getReviewData() {
		return ReviewService.getReviews();
	}

	@GetMapping("/Reviews/{id}")
	public Optional<ReviewData> getAccessory(@PathVariable long id) {
		return ReviewService.getSpecificReview(id);
	}

	@PostMapping("/Reviews")
	public ReviewData addAcs(@RequestBody ReviewData ud) {
		return ReviewService.getAddedReview(ud);
	}

	@PutMapping("/Reviews")
	public ReviewData updateAcs(@RequestBody ReviewData ud) {
		return ReviewService.getUpdatedReview(ud);
	}

	@DeleteMapping("/Reviews/{id}")
	public ResponseEntity<HttpStatus> DeleteAccessory(@PathVariable String id) {
		try {
			ReviewService.deleteReview(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
