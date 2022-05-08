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
import com.restaurant.management.util.Constants;
import com.restaurant.management.dto.TransportDto;
import com.restaurant.management.dto.TransportSearchDto;
import com.restaurant.management.entities.Transport;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.TransportService;
import com.restaurant.management.util.EndPointURI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransportController {
	@Autowired
	private TransportService transportService;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndPointURI.TRANSPORT)
	public ResponseEntity<Object> addTransport(@Valid @RequestBody TransportDto transportDto) {
		transportService.saveTransport(mapper.map(transportDto, Transport.class));
		return new ResponseEntity<>(Constants.ADD_TRANSPORT_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.TRANSPORT)
	public ResponseEntity<Object> getAllTransport() {
		return new ResponseEntity<Object>(mapper.map(transportService.getTransports(), TransportDto.class),
				HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.TRANSPORT_BY_ID)
	public ResponseEntity<Object> getTransportById(@PathVariable Long id) {
		if (transportService.isTransportIdExists(id)) {
			return new ResponseEntity<>(mapper.map(transportService.getTransportById(id), TransportDto.class),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(Constants.TRANSPORT, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndPointURI.TRANSPORT_SEARCH)
	public ResponseEntity<Object> searchTransport(TransportSearchDto transportDto) {
		return new ResponseEntity<>(
				mapper.map(transportService.multipulSearchTransport(transportDto), TransportSearchDto.class),
				HttpStatus.OK);
	}

	@DeleteMapping(value = EndPointURI.TRANSPORT_BY_ID)
	public ResponseEntity<Object> deleteTransportDetail(@PathVariable Long id) {
		if (!transportService.isTransportIdExists(id)) {
			return new ResponseEntity<>(Constants.TRANSPORT, HttpStatus.BAD_REQUEST);
		}
		transportService.deleteTransportDetail(id);
		return new ResponseEntity<Object>(Constants.DELETE_TRANSPORT_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndPointURI.TRANSPORT)
	public ResponseEntity<Object> editTransport(@Valid @RequestBody TransportDto transportDto) {
		if (!transportService.isTransportIdExists(transportDto.getId())) {
			return new ResponseEntity<>(Constants.TRANSPORT, HttpStatus.BAD_REQUEST);
		}
		transportService.updateTransport(mapper.map(transportDto, Transport.class));
		return new ResponseEntity<>(Constants.EDIT_TRANSPORT_SUCCESS, HttpStatus.OK);

	}
}
