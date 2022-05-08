package com.restaurant.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.restaurant.management.dto.TransportSearchDto;
import com.restaurant.management.entities.QTransport;
import com.restaurant.management.entities.Transport;
import com.restaurant.management.repositories.TransportRepository;
import com.restaurant.management.util.Utils;

@Service
public class TransportServiceImpl implements TransportService {

	@Autowired
	private TransportRepository transportRepository;

	@Override
	public void saveTransport(Transport transport) {
		transportRepository.save(transport);
	}

	@Override
	public List<Transport> getTransports() {
		return transportRepository.findAll();
	}

	@Override
	public boolean isTransportIdExists(Long id) {
		return transportRepository.existsById(id);
	}

	@Override
	public Transport getTransportById(Long id) {
		return transportRepository.findById(id).get();
	}

	@Override
	public String deleteTransportDetail(Long id) {
		transportRepository.deleteById(id);
		return "Transport Detail Removed !! " + id;
	}

	@Override
	public void updateTransport(Transport transport) {
		transportRepository.save(transport);
	}

	@Transactional
	public List<Transport> multipulSearchTransport(TransportSearchDto transportDto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (Utils.isNotNullAndEmpty(transportDto.getVehicleType())) {
			booleanBuilder.and(QTransport.transport.vehicleType.containsIgnoreCase(transportDto.getVehicleType()));
		}

		return (List<Transport>) transportRepository.findAll(booleanBuilder);
	}

}
