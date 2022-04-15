package com.restaurant.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.management.entities.VehicleBooking;
import com.restaurant.management.repositories.VehicleBookingRepository;

@Service
public class VehicleBookingServiceImpl implements VehicleBookingService {

	@Autowired
	private VehicleBookingRepository vehicleBookingRepository;

	@Override
	public void saveVehicleBooking(VehicleBooking vehicleBooking) {
		vehicleBookingRepository.save(vehicleBooking);
	}

}
