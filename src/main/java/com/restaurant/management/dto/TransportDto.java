package com.restaurant.management.dto;

public class TransportDto {
	private Long id;
	private String vehicleName;
	private String vehiclefacilities;
	private double cost;
	private String vehicleType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehiclefacilities() {
		return vehiclefacilities;
	}

	public void setVehiclefacilities(String vehiclefacilities) {
		this.vehiclefacilities = vehiclefacilities;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
