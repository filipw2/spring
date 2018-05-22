package com.itemtracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemtracker.model.dao.Cena;
import com.itemtracker.model.dao.CenaRepository;

@Service
public class CenaService {

	@Autowired
	private CenaRepository cenaRepository;

	public CenaService() {

	}

	public void insertCenas(List<Cena> cenas) {
		
		for (Cena c : cenas) {
			if(c.getDane_id().getId()==0) {
				saveWithCurrentDate(c);
				continue;
			}
			Cena old = cenaRepository.getLatestCena(c.getDane_id().getId());
			if (old == null) {
				saveWithCurrentDate(c);
				continue;
			}

			if (old.getCena_bez_akcyzy() != c.getCena_bez_akcyzy() || old.getCena_z_akcyza() != c.getCena_z_akcyza()) {
				saveWithCurrentDate(c);
			}
		}

	}
	
	private void saveWithCurrentDate(Cena c) {
		c.setData(new Date());
		try {
		cenaRepository.save(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
