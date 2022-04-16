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
@Table(name = "banquet")
@Getter
@Setter
public class Banquet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String guestName;
	private long mobileNumber;
	private String eventType;
	private String additionalService;
	private String decoration;
	private Date dateOfEvent;
}
