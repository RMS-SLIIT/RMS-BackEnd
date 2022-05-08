package com.restaurant.management.util;

public class EndPointURI {
	private static final String BASE_API_PATH = "/api/v1/";
	private static final String SLASH = "/";
	private static final String ID = "{id}";

	// banquet
	public static final String BANQUET = BASE_API_PATH + "banquet";
	public static final String BANQUET_BY_ID = BANQUET + SLASH + ID;
	public static final String BANQUET_SEARCH = BASE_API_PATH + "banquetsearch";

	// roomBooking
	public static final String ROOMBOOKING = BASE_API_PATH + "roomBooking";
	public static final String ROOMBOOKING_BY_ID = ROOMBOOKING + SLASH + ID;
	public static final String ROOMBOOKING_SEARCH = BASE_API_PATH + "roombookingsearch";

	// employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	private static final String EMPLOYEE_ID = "{employeeId}";
	public static final String EMPLOYEE_BY_EMPLOYEE_ID = EMPLOYEE + SLASH + EMPLOYEE_ID;
	public static final String EMPLOYEE_BY_ID = EMPLOYEE + SLASH + ID;
	public static final String EMPLOYEE_SEARCH = BASE_API_PATH + "employeesearch";

	// vehicleBooking
	public static final String VEHICLEBOOKING = BASE_API_PATH + "vehicleBooking";
	public static final String VEHICLEBOOKING_BY_ID = VEHICLEBOOKING + SLASH + ID;
	public static final String VEHICLEBOOKING_SEARCH = BASE_API_PATH + "vehiclebookingsearch";

	// inventory
	public static final String INVENTORY = BASE_API_PATH + "inventory";
	public static final String INVENTORY_BY_ID = INVENTORY + SLASH + ID;
	public static final String INVENTORY_SEARCH = BASE_API_PATH + "inventorysearch";

	// roomDetail
	public static final String ROOMDETAIL = BASE_API_PATH + "roomdetail";
	public static final String ROOMDETAIL_BY_ID = ROOMDETAIL + SLASH + ID;
	public static final String ROOMDETAIL_SEARCH = BASE_API_PATH + "roomdetailsearch";

	// transport
	public static final String TRANSPORT = BASE_API_PATH + "transport";
	public static final String TRANSPORT_BY_ID = TRANSPORT + SLASH + ID;
	public static final String TRANSPORT_SEARCH = BASE_API_PATH + "transportsearch";

	// food
	public static final String FOOD = BASE_API_PATH + "food";
	public static final String FOOD_BY_ID = FOOD + SLASH + ID;
	public static final String FOOD_SEARCH = BASE_API_PATH + "foodsearch";

}
