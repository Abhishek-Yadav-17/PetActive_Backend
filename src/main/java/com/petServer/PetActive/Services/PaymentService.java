package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.PaymentDAO;
import com.petServer.PetActive.entities.PaymentData;


@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAO pDao;

	public List<PaymentData> getPayments() {
		return pDao.findAll();
	}

	public Optional<PaymentData> getSpecificPayment(long id) {
		Optional<PaymentData> o = pDao.findById(id);
		return o;
	}

	public PaymentData getUpdatedPayment(PaymentData od) {
		PaymentData o = od;
		pDao.save(o);
		return o;
	}

	public PaymentData getAddedPayment(PaymentData od) {
		PaymentData o = od;
		pDao.save(o);
		return o;
	}

	public void deletePayment(long id) {
		pDao.deleteById(id);
	}

}
