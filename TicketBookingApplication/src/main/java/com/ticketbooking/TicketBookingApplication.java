package com.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticketbooking.model.Ticket;
import com.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner{
	@Autowired
	private TicketService ticketService;
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("Ravi Ranjan");
		ticketObj.setSourceStation("Patna");
		ticketObj.setDestinationStation("Delhi");
		ticketObj.setTravelDate(new Date());
		ticketObj.setEmail("Ravi2840@gramil.com");
		ticketService.createTicket(ticketObj);
		
	
	}

}
