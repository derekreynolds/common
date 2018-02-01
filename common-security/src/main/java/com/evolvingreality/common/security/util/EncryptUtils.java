/**
 * 
 */
package com.evolvingreality.common.security.util;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * This class contains static methods around encryption.
 * @author Derek Reynolds
 * @since 1.0
 */
public abstract class EncryptUtils {

	/**
	 * This method encodes the password based on the SHA256.
	 * A salt should also be provided for extra security.
	 * @param password
	 * @param salt
	 * @return the encoded password
	 */
	public static String encodePassword(String password, String salt) {
		
		PasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		return passwordEncoder.encodePassword(password, salt);

	}
	
}
