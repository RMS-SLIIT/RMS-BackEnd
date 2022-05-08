package com.restaurant.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.restaurant.management.dto.VehicleBookingSearchDto;
import com.restaurant.management.entities.QVehicleBooking;
import com.restaurant.management.entities.VehicleBooking;
import com.restaurant.management.repositories.VehicleBookingRepository;
import com.restaurant.management.util.Utils;

@Service
public class VehicleBookingServiceImpl implements VehicleBookingService {

	@Autowired
	private VehicleBookingRepository vehicleBookingRepository;

	@Transactional
	public void saveVehicleBooking(VehicleBooking vehicleBooking) {
		vehicleBookingRepository.save(vehicleBooking);
	}

	@Transactional(readOnly = true)
	public List<VehicleBooking> getVehicleBookingDetails() {
		return vehicleBookingRepository.findAll();
	}

	@Transactional
	public boolean isVehicleBookingIdExists(Long id) {
		return vehicleBookingRepository.existsById(id);
	}

	@Transactional(readOnly = true)
	public VehicleBooking getVehicleBookingDetailById(Long id) {
		return vehicleBookingRepository.findById(id).get();
	}

	@Transactional
	public String deleteVehicleBookingDetail(Long id) {
		vehicleBookingRepository.deleteById(id);
		return "Vehicle Booking Detail Removed !! " + id;
	}

	@Transactional
	public List<VehicleBooking> multipulSearchVehicleBooking(VehicleBookingSearchDto vehicleBookingSearchDto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (Utils.isNotNullAndEmpty(vehicleBookingSearchDto.getNic())) {
			booleanBuilder.and(QVehicleBooking.vehicleBooking.nic.containsIgnoreCase(vehicleBookingSearchDto.getNic()));
		}

		return (List<VehicleBooking>) vehicleBookingRepository.findAll(booleanBuilder);
	}

	@Override
	public void updateVehicle(VehicleBooking vehicleBooking) {
		vehicleBookingRepository.save(vehicleBooking);
	}

}
