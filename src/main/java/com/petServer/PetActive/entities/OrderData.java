package com.petServer.PetActive.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ord_id;
	private Date date;
	private double amount;
	private String status;
	@OneToOne
	@JoinColumn(name = "fk_usr_id")
	private UserData ud;

	public void setOrd_id(Long ord_id) {
		this.ord_id = ord_id;
	}

	public UserData getUd() {
		return ud;
	}

	public void setUd(UserData ud) {
		this.ud = ud;
	}

	public Long getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(long ord_id) {
		this.ord_id = ord_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
