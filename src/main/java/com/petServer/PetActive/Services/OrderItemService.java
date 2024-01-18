package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.OrderItemDAO;
import com.petServer.PetActive.entities.OrderItemData;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemDAO oDao;

	public List<OrderItemData> getOrderItems() {
		return oDao.findAll();
	}

	public Optional<OrderItemData> getSpecificOrderItem(long id) {
		Optional<OrderItemData> o = oDao.findById(id);
		return o;
	}

	public OrderItemData getUpdatedOrderItem(OrderItemData od) {
		OrderItemData o = od;
		oDao.save(o);
		return o;
	}

	public OrderItemData getAddedOrderItem(OrderItemData od) {
		OrderItemData o = od;
		oDao.save(o);
		return o;
	}

	public void deleteOrderItem(long id) {
		oDao.deleteById(id);
	}

}
