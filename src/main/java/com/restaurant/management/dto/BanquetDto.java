package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanquetDto {
	private Long id;
	private String questName;
	private long mobileNumber;
	private String eventType;
	private String decoration;
	private Date dateOfEvent;
}
