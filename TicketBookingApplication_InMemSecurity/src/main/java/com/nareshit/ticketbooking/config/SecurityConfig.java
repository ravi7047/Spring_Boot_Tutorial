package com.nareshit.ticketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


//Authentication Logic

//1) Need to create user with nareshitadmin / nareshitadmin with ADMIN Role
//2) Need to create user with nareshitguest / nareshitguest with USER Role


	@Autowired
	private void configure_global(AuthenticationManagerBuilder authObj) throws Exception {

		//NARESHITADMIN/NARESHITADMIN
		//{noop} is the key word which will encode the password using default sboot algorithm without using
		//passwordEncoder. Since framework does not take plain password
		authObj.inMemoryAuthentication().withUser("nareshitadmin").password("{noop}nareshitadmin").roles("ADMIN");

		authObj.inMemoryAuthentication().withUser("nareshitguest").password("{noop}nareshitguest").roles("USER");


	}




//Authorization Logic
	@Override
	public void configure(HttpSecurity authorizationObj) throws Exception{


		//Rule1 ==> ADMIN Role can Access All Tickets Method
		authorizationObj.csrf().disable()//This i will explain in tomarrow lass
		.authorizeRequests().antMatchers("/tickets/admin/**").hasAnyRole("ADMIN")
		.and().formLogin();           //formLogin will render Login Page


		//Guest Role Can access Individual Ticket
		authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/tickets/ticket/**").hasAnyRole("ADMIN","USER")
		.and().formLogin();                     //Individual ticket can be

	}



}
