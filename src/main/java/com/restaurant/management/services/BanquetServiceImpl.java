package com.restaurant.management.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.management.entities.Banquet;
import com.restaurant.management.repositories.BanquetRepository;

@Service
public class BanquetServiceImpl implements BanquetService {

	@Autowired
	private BanquetRepository banquetRepository;

	@Transactional
	public void saveBanquet(Banquet banquet) {
		banquetRepository.save(banquet);
	}

	@Transactional
	public boolean isDateOfEventExists(Date dateOfEvent) {
		return banquetRepository.existsByDateOfEvent(dateOfEvent);
	}

	@Transactional(readOnly = true)
	public List<Banquet> getBanquets() {
		return banquetRepository.findAll();
	}

}
