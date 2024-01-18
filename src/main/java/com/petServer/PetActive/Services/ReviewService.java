package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.ReviewDAO;
import com.petServer.PetActive.entities.ReviewData;


@Service
public class ReviewService {
	
	@Autowired
	private ReviewDAO rDao;

	public List<ReviewData> getReviews() {
		return rDao.findAll();
	}

	public Optional<ReviewData> getSpecificReview(long id) {
		Optional<ReviewData> o = rDao.findById(id);
		return o;
	}

	public ReviewData getUpdatedReview(ReviewData od) {
		ReviewData o = od;
		rDao.save(o);
		return o;
	}

	public ReviewData getAddedReview(ReviewData od) {
		ReviewData o = od;
		rDao.save(o);
		return o;
	}

	public void deleteReview(long id) {
		rDao.deleteById(id);
	}

}
