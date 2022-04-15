package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBookingDto {
	private Long id;
	private String fullName;
	private String nic;
	private long mobileNumber;
	private int noOfPerson;
	private Date checkInDate;
	private Date checkOutDate;
}
