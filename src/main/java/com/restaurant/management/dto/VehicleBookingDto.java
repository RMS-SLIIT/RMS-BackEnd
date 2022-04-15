package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleBookingDto {
	private Long id;
	private String userName;
	private String nic;
	private long mobileNumber;
	private String email;
	private Date checkIn;
	private Date checkOut;
	private int noOfKm;
	private double cost;
}
