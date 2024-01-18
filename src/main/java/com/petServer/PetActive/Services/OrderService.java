package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.OrderDAO;
import com.petServer.PetActive.dao.OrderItemDAO;
import com.petServer.PetActive.entities.OrderData;
import com.petServer.PetActive.entities.OrderItemData;


@Service
public class OrderService {

	@Autowired
	private OrderDAO oDao;

	@Autowired
	private OrderItemDAO cid;

	public List<OrderData> getOrders() {
		return oDao.findAll();
	}

	public Optional<OrderData> getSpecificOrder(long id) {
		Optional<OrderData> o = oDao.findById(id);
		return o;
	}

	public OrderData getUpdatedOrder(OrderData od) {
		OrderData o = od;
		oDao.save(o);
		return o;
	}

	public OrderData getAddedOrder(OrderData od) {
		OrderData o = od;
		List<OrderItemData> c = cid.findAll();
		double a = 0;
		for (OrderItemData ci : c) {
			a = a + ci.getAmount();
		}
		o.setAmount(a);
		oDao.save(o);
		return o;
	}

	public void deleteOrder(long id) {
		oDao.deleteById(id);
	}

}
