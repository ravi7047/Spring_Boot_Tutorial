package com.springboot.CustomSecurityWithDB;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println("Password for Swetha...... " +bCryptPasswordEncoder.encode("Swetha"));
		System.out.println("Password for Harsha...... " +bCryptPasswordEncoder.encode("Harsha"));
		//$2a$10$6w6rjJXJMwIs0Cn9psNyu.Zjo1e18754Wjsxiev.PDAlbO1dlbuDu
		//$2a$10$AMN7cfdX1pRTp.SCGAEgTu2JH6AAmjt/.MoGx3bJ8WLK6gbJMdcvK
		//System.out.println("Password for Guest...... " +bCryptPasswordEncoder.encode("guest"));
	}
}
