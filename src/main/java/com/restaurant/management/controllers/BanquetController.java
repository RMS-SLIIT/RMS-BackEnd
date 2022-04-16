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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.BanquetDto;
import com.restaurant.management.entities.Banquet;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.BanquetService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BanquetController {

	@Autowired
	private BanquetService banquetService;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndPointURI.BANQUET)
	public ResponseEntity<Object> addBanquet(@Valid @RequestBody BanquetDto banquetDto) {
		if (banquetService.isDateOfEventExists(banquetDto.getDateOfEvent())) {
			return new ResponseEntity<>(Constants.BANQUET, HttpStatus.BAD_REQUEST);
		}
		banquetService.saveBanquet(mapper.map(banquetDto, Banquet.class));
		return new ResponseEntity<>(Constants.ADD_BANQUET_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.BANQUET)
	public ResponseEntity<Object> getAllBanquets() {
		return new ResponseEntity<Object>(mapper.map(banquetService.getBanquets(), BanquetDto.class), HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.BANQUET_BY_ID)
	public ResponseEntity<Object> getBanquetById(@PathVariable Long id) {
		if (banquetService.isBanquetIdExists(id)) {
			return new ResponseEntity<>(mapper.map(banquetService.getProductById(id), BanquetDto.class), HttpStatus.OK);
		}
		return new ResponseEntity<>(Constants.BANQUET, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = EndPointURI.BANQUET_BY_ID)
	public ResponseEntity<Object> deleteBanquetDetail(@PathVariable Long id) {
		if (!banquetService.isBanquetIdExists(id)) {
			return new ResponseEntity<>(Constants.BANQUET, HttpStatus.BAD_REQUEST);
		}
		banquetService.deleteBanquetDetail(id);
		return new ResponseEntity<Object>(Constants.DELETE_BANQUET_SUCCESS, HttpStatus.OK);
	}
}
