/**
 * 
 */
package com.evolvingreality.common.persistence.domain;


/**
 * Holds common Spring profiles.
 * @author Derek Reynolds
 *
 */
public enum SpringProfiles {
	
	LIQUIBASE("liquibase"),
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
