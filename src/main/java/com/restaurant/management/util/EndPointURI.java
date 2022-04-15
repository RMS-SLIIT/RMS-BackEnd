package com.restaurant.management.util;

public class EndPointURI {
	private static final String BASE_API_PATH = "/api/v1/";
	private static final String SLASH = "/";
	private static final String ID = "{id}";

	// banquet
	public static final String BANQUET = BASE_API_PATH + "banquet";
	public static final String BANQUET_BY_ID = BANQUET + SLASH + ID;
}
