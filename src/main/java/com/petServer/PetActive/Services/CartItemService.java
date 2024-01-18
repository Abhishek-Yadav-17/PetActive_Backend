package com.petServer.PetActive.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petServer.PetActive.dao.CartItemDAO;
import com.petServer.PetActive.entities.CartItemData;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemDAO cDAo;

	public List<CartItemData> getCartItems() {
		return cDAo.findAll();
	}

	public List<CartItemData> getSpecificCartItem(long cart_id) {
		List<CartItemData> o = new ArrayList<>();
		for(CartItemData a : cDAo.findAll()) {
			if(a.getCd().getId() == cart_id) {
				o.add(a);
			}
		}
		return o;
	}

	public CartItemData getUpdatedCartItem(CartItemData od) {
		CartItemData o = od;
		cDAo.save(o);
		return o;
	}

	public CartItemData getAddedCartItem(CartItemData od) {
		od.setDate(LocalDate.now().toString());
		for(CartItemData x : cDAo.findAll()) {
			if(cDAo.findAll()!=null && od.getAcs().getId().equals(x.getAcs().getId()) && od.getCd().getId().equals(x.getCd().getId())) {	
				x.setQuantity(x.getQuantity()+od.getQuantity());
				cDAo.save(x);
				return x;
			}
		}
		cDAo.save(od);
		return od;
	}

	public void deleteCartItem(long id) {
		cDAo.deleteById(id);
	}

}
