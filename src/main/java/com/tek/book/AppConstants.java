package com.tek.book;

/**
 * @author Vinoth
 *
 */
public class AppConstants {

	private AppConstants() {
	}

	public static final String ADMINISTRATOR = "hasAuthority('ROLE_ADMIN')";
	public static final String CONTRACTOR = "hasAuthority('ROLE_CONTRACTOR')";
	public static final String SITE_ENGINEER = "hasAuthority('ROLE_SITE_ENGINEER')";
	public static final String PROJECT_MANAGER = "hasAuthority('ROLE_PROJECT_MANAGER')";
	public static final String RVNL = "hasAuthority('ROLE_RVNL')";
	
	public static final String NUMBER="[0-9]+";
	public static final String UPPERCASE="[0-9a-z]+";

}
