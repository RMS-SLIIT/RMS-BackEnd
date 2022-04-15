package com.restaurant.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.management.entities.RoomBooking;
import com.restaurant.management.repositories.RoomBookingRepository;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

	@Autowired
	private RoomBookingRepository roomBookingRepository;

	@Transactional
	public void saveRoomBooking(RoomBooking roomBooking) {
		roomBookingRepository.save(roomBooking);
	}

}
