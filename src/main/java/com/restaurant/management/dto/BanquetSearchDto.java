package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanquetSearchDto {

	private String guestName;
	private String eventType;
	private String additionalService;
	private String decoration;
	private Date dateOfEvent;
}
