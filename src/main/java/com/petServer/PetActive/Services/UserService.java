package com.petServer.PetActive.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.CartDAO;
import com.petServer.PetActive.dao.UsersDAO;
import com.petServer.PetActive.entities.CartData;
import com.petServer.PetActive.entities.UserData;

@Service
public class UserService {

	@Autowired
	private UsersDAO uDao;

	@Autowired
	private CartDAO cDao;

	public List<UserData> getUsers() {
		return uDao.findAll();
	}

	public Optional<UserData> getSpecificUser(String id) {
		Optional<UserData> u = uDao.findById(id);
		return u;
	}

	public UserData getUpdatedUser(UserData ud) {
		uDao.save(ud);
		return ud;
	}

	public UserData getAddedUser(UserData ud) {
		CartData c = new CartData();
		c.setCust_id(ud);
		uDao.save(ud);
		cDao.save(c);
		return ud;
	}

	@Autowired
	CartService cs;
	public void deleteUser(String id) {
		cs.deleteCart(id);
		uDao.deleteById(id);
	}

}
