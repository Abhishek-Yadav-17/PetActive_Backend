package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.CartDAO;
import com.petServer.PetActive.dao.CartItemDAO;
import com.petServer.PetActive.dao.UsersDAO;
import com.petServer.PetActive.entities.CartData;
import com.petServer.PetActive.entities.CartItemData;
import com.petServer.PetActive.entities.UserData;

@Service
public class CartService {

	@Autowired
	private CartDAO cDao;

	@Autowired
	private CartItemDAO cid;

	@Autowired
	private UsersDAO uDao;

	public List<CartData> getCarts() {
		return cDao.findAll();
	}

	public CartData getSpecificCart(String uid) {
		CartData o = null;
		Optional<UserData> u = uDao.findById(uid);
		if (u.isPresent()) {
			UserData n = u.get();
			for (CartData c : cDao.findAll()) {
				if (c.getCust_id() == n) {
					o = c;
					break;
				}
			}
			CartData x = o;
			double amount = 0;
			List<CartItemData> c = cid.findAll();
			for (CartItemData ci : c) {
				if (ci.getCd().equals(x)) {
					amount += ci.getAcs().getPrice() * ci.getQuantity();
				}
			}
			x.setAmount(amount);
			cDao.save(x);
		}
		return o;
	}

	public CartData getUpdatedCart(CartData od) {
		cDao.save(od);
		return od;
	}

	public CartData getAddedCart(CartData od) {
		cDao.save(od);
		return od;
	}

	public void deleteCart(String uid) {
		CartData o = null;
		Optional<UserData> u = uDao.findById(uid);
		if (u.isPresent()) {
			UserData n = u.get();
			for (CartData c : cDao.findAll()) {
				if (c.getCust_id() == n) {
					o = c;
					break;
				}
			}
			cDao.delete(o);
		}
	}

}
