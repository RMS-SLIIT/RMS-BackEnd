package com.restaurant.management.util;

public class EndPointURI {
	private static final String BASE_API_PATH = "/api/v1/";
	private static final String SLASH = "/";
	private static final String ID = "{id}";

	// banquet
	public static final String BANQUET = BASE_API_PATH + "banquet";
	public static final String BANQUET_BY_ID = BANQUET + SLASH + ID;

	// roomBooking
	public static final String ROOMBOOKING = BASE_API_PATH + "roomBooking";
	public static final String ROOMBOOKING_BY_ID = ROOMBOOKING + SLASH + ID;

	// employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	private static final String EMPLOYEE_ID = "{employeeId}";
	public static final String EMPLOYEE_BY_EMPLOYEE_ID = EMPLOYEE + SLASH + EMPLOYEE_ID;
	public static final String EMPLOYEE_BY_ID = EMPLOYEE + SLASH + ID;

}
