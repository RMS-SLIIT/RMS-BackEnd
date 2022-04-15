package com.restaurant.management.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicleBooking")
@Getter
@Setter
public class VehicleBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
