package com.petServer.PetActive.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReviewData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;
	private int rating;
	private String comment;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData ud;

	public UserData getUd() {
		return ud;
	}

	public void setUd(UserData ud) {
		this.ud = ud;
	}

	public long getReviewId() {
		return review_id;
	}

	public void setReviewId(long reviewId) {
		this.review_id = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
