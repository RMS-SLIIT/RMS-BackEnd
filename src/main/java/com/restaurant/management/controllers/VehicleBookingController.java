package com.restaurant.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.VehicleBookingDto;
import com.restaurant.management.dto.VehicleBookingSearchDto;
import com.restaurant.management.entities.VehicleBooking;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.VehicleBookingService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@CrossOrigin(origins = "http://localhost:3000")
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

	@GetMapping(value = EndPointURI.VEHICLEBOOKING)
	public ResponseEntity<Object> getAllVehicleBookingDetails() {
		return new ResponseEntity<Object>(
				mapper.map(vehicleBookingService.getVehicleBookingDetails(), VehicleBookingDto.class), HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.VEHICLEBOOKING_BY_ID)
	public ResponseEntity<Object> getVehicleBookingDetailById(@PathVariable Long id) {
		if (vehicleBookingService.isVehicleBookingIdExists(id)) {
			return new ResponseEntity<>(
					mapper.map(vehicleBookingService.getVehicleBookingDetailById(id), VehicleBookingDto.class),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(Constants.VEHICLEBOOKING, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = EndPointURI.VEHICLEBOOKING_BY_ID)
	public ResponseEntity<Object> deleteVehicleBookingDetail(@PathVariable Long id) {
		if (!vehicleBookingService.isVehicleBookingIdExists(id)) {
			return new ResponseEntity<>(Constants.VEHICLEBOOKING, HttpStatus.BAD_REQUEST);
		}
		vehicleBookingService.deleteVehicleBookingDetail(id);
		return new ResponseEntity<Object>(Constants.DELETE_VEHICLEBOOKING_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.VEHICLEBOOKING_SEARCH)
	public ResponseEntity<Object> searchVehicleBooking(VehicleBookingSearchDto vehicleBookingSearchDto) {
		return new ResponseEntity<>(
				mapper.map(vehicleBookingService.multipulSearchVehicleBooking(vehicleBookingSearchDto),
						VehicleBookingDto.class),
				HttpStatus.OK);
	}

	@PutMapping(value = EndPointURI.VEHICLEBOOKING)
	public ResponseEntity<Object> editVehicleBooking(@Valid @RequestBody VehicleBookingDto vehicleBookingDto) {
		if (!vehicleBookingService.isVehicleBookingIdExists(vehicleBookingDto.getId())) {
			return new ResponseEntity<>(Constants.INVENTORY, HttpStatus.BAD_REQUEST);
		}
		VehicleBooking vbook = new VehicleBooking();
		vbook = vehicleBookingService.getVehicleBookingDetailById(vehicleBookingDto.getId());
		vehicleBookingDto.setCheckIn(vbook.getCheckIn());
		vehicleBookingDto.setCheckOut(vbook.getCheckOut());
		vehicleBookingService.updateVehicle(mapper.map(vehicleBookingDto, VehicleBooking.class));
		return new ResponseEntity<>(Constants.UPDATE_EMPLOYEE_SUCCESS, HttpStatus.OK);
	}

}
