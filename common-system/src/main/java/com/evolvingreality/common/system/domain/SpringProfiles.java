/**
 * 
 */
package com.evolvingreality.common.system.domain;


/**
 * Holds common Spring profiles.
 * @author Derek Reynolds
 *
 */
public enum SpringProfiles {
	
	LIQUIBASE("liquibase"),
	CLOUD("cloud"),
	DEVELOPMENT("development"),
	SIT("sit"),
	UAT("uat"),
	PRODUCTION("production");
	
	private final String profile;
	
	SpringProfiles(final String profile) {
		this.profile = profile;
	}
	
	public String getProfile() {
		return this.profile;
	}
}
