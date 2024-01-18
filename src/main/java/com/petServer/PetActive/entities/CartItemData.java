package com.petServer.PetActive.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItemData {
//	{
//        "date": "",
//        "quantity": 5,
//        "amount": 99.0,
//        "acs": {
//            "id": 11,
//            "name": "Dog Cloth",
//            "type": "cloth",
//            "category": "clothing",
//            "color": "Brown",
//            "price": 999.0,
//            "stock": 1000,
//            "descption": "Good quality",
//            "imgUrl": "https://cdn-icons-png.flaticon.com/512/666/666201.png",
//            "md": {
//                "id": "abhi1232yadav@gmail.com",
//                "name": "Abhi",
//                "country": "India",
//                "imgUrl": null
//            }
//        },
//        "cd": {
//            "id": 3,
//            "amount": 2000.0,
//            "cust_id": {
//                "email": "pran12@gmail.com",
//                "pw": "Pran@1234",
//                "name": "Pranay D. Kale",
//                "dob": "15/12/2000",
//                "gender": "M",
//                "phone": "6386653849",
//                "city": "Mumbai",
//                "imgUrl": null,
//                "idType": null,
//                "idNum": null
//            }
//        }
//    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CartItem_id;
	private String date;
	private int quantity;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "acs_id")
	private Accessories acs;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartData cd;

	public CartData getCd() {
		return cd;
	}

	public void setCd(CartData cd) {
		this.cd = cd;
	}

	public Accessories getAcs() {
		return acs;
	}

	public void setAcs(Accessories acs) {
		this.acs = acs;
	}

	public Long getCartItem_id() {
		return CartItem_id;
	}

	public void setCartItem_id(Long CartItem_id) {
		this.CartItem_id = CartItem_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
