package com.restaurant.management.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
	private Long id;
	private String supplierName;
	private Date supplierDisappliedDate;
	private int quantity;
	private double price;
}
