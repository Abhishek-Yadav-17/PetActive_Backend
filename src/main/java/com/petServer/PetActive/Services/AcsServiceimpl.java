package com.petServer.PetActive.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petServer.PetActive.dao.AcsDAO;
import com.petServer.PetActive.entities.Accessories;

@Service
public class AcsServiceimpl implements AcsService {
	
	@Autowired
	private AcsDAO aDao;
//	List<Accessories> acs;

//	public AcsServiceimpl() {
//		acs = new ArrayList<>();
//		acs.add(new Accessories(1, "belt", "Leather, Brown"));
//		acs.add(new Accessories(2, "Cloth", "good, Brown"));
//		acs.add(new Accessories(3, "Vaccine", "Best"));
//	}

	@Override
	public List<Accessories> getAccessories() {
		return aDao.findAll();
	}
	

	@Override
	public List<Accessories> getSpecificAccessories(String category) {		
		List<Accessories> aList = new ArrayList<>();
		for(Accessories as : aDao.findAll()) {
			if(as.getCategory().equals(category)) {
				aList.add(as);
			}
		}
		return aList;
	}
	
	@Override
	public Optional<Accessories> getSpecificAcsId(Long id) {		
		return aDao.findById(id);
	}

	@Override
	public Accessories getAddedAcs(Accessories acc) {
//		acs.add(acc);
		aDao.save(acc);
		return acc;
	}

	@Override
	public Accessories getUpdatedAcs(Accessories acc) {
//		for(Accessories as : aDao.findAll()) {
//			if(as.getId() == (acc.getId())) {
//				as.setId(acc.getId());
//				as.setName(acc.getName());
//				as.setDesc(acc.getDesc());
//				break;
//			}
//		}
		aDao.save(acc);
		return acc;
	}

	@Override
	public void getDeletedAccessories(long id) {
//		Accessories a = null;
//		for(Accessories as : aDao.findAll()) {
//			if(as.getId() == id) {
//				a = as;
//				acs.remove(as);
//				break;
//			}
//		}
//		return a;
		aDao.deleteById(id);
	}


	@Override
	public Set<String> getCate() {
		Set<String> s = new TreeSet<>();
		for(Accessories a : aDao.findAll()) {
			s.add(a.getCategory());
		}
		return s;
	}

}
