package com.restaurant.management.services;

import java.util.List;

import com.restaurant.management.dto.TransportSearchDto;
import com.restaurant.management.entities.Transport;


public interface TransportService {
	public void saveTransport(Transport transport);

	public List<Transport> getTransports();

	public boolean isTransportIdExists(Long id);

	public Transport getTransportById(Long id);

	public String deleteTransportDetail(Long id);

	public void updateTransport(Transport transport);

	public List<Transport> multipulSearchTransport(TransportSearchDto transportDto);
}
