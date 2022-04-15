package com.restaurant.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.RoomBookingDto;
import com.restaurant.management.entities.RoomBooking;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.RoomBookingService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@RestController
public class RoomBookingController {

	@Autowired
	private RoomBookingService roomBookingService;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndPointURI.ROOMBOOKING)
	public ResponseEntity<Object> addRoomBooking(@Valid @RequestBody RoomBookingDto roomBookingDto) {
		roomBookingService.saveRoomBooking(mapper.map(roomBookingDto, RoomBooking.class));
		return new ResponseEntity<>(Constants.ADD_ROOMBOOKING_SUCCESS, HttpStatus.OK);
	}
}
