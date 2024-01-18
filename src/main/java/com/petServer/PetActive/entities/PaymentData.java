package com.petServer.PetActive.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PaymentData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transaction_id;
	private double amount;
	private Date date;
	private String method;

	@OneToOne
	@JoinColumn(name = "ord_id")
	private OrderData od;

	public OrderData getOd() {
		return od;
	}

	public void setOd(OrderData od) {
		this.od = od;
	}

	public long getTansaction_id() {
		return getTansaction_id();
	}

	public void setTansaction_id(long tansaction_id) {
		this.transaction_id = tansaction_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
