package com.restaurant.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.VehicleBookingDto;
import com.restaurant.management.entities.VehicleBooking;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.VehicleBookingService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@RestController
public class VehicleBookingController {
	@Autowired
	private VehicleBookingService vehicleBookingService;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndPointURI.VEHICLEBOOKING)
	public ResponseEntity<Object> addVehicleBooking(@Valid @RequestBody VehicleBookingDto vehicleBookingDto) {
		vehicleBookingService.saveVehicleBooking(mapper.map(vehicleBookingDto, VehicleBooking.class));
		return new ResponseEntity<>(Constants.ADD_VEHICLEBOOKING_SUCCESS, HttpStatus.OK);
	}

}
