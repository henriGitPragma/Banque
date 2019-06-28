package com.ProjetMaBanque.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncrytedPasswordUtils  {
	 
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        //return new BCryptPasswordEncoder();
	    }
	

}
