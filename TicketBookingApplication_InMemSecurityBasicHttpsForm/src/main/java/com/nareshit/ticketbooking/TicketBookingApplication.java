package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner{


	@Autowired
	private TicketService ticketService;

	//CommandLineRunner ==> We should implement run method and run method will be called only during startup
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("SANDHYA");
		ticketObj.setSourceStation("HYDERABAD");
		ticketObj.setDestinationStation("GOA");
		ticketObj.setTravelDate(new Date());
		ticketObj.setEmail("vijumca@gmail.com");

		ticketService.createTicket(ticketObj);

	}

}
