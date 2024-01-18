package com.petServer.PetActive.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItemData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordItem_id;
	private int quantity;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "ord_id")
	private OrderData od;

	@ManyToOne
	@JoinColumn(name = "acs_id")
	private Accessories acs;

	public Accessories getAcs() {
		return acs;
	}

	public void setAcs(Accessories acs) {
		this.acs = acs;
	}

	public void setOrdItem_id(Long ordItem_id) {
		this.ordItem_id = ordItem_id;
	}

	public OrderData getOd() {
		return od;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setOd(OrderData od) {
		this.od = od;
	}

	public long getOrdItem_id() {
		return ordItem_id;
	}

	public void setOrdItem_id(long ordItem_id) {
		this.ordItem_id = ordItem_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
