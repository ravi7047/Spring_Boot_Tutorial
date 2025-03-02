package com.springboot.ticketbooking;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.ticketbooking.entities.Ticket;
import com.springboot.ticketbooking.service.TicketBookingService;

@SpringBootApplication
public class TicketBoookngManagmentAppApplication implements CommandLineRunner {

	@Autowired
	private TicketBookingService ticketBookingService;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		//ConfigurableApplicationContext applicatoinContext = SpringApplication
			//	.run(TicketBoookngManagmentAppApplication.class, args);
		SpringApplication
		.run(TicketBoookngManagmentAppApplication.class, args);
		//TicketBookingService ticketBookingService = applicatoinContext.getBean("ticketBookingService",
		//		TicketBookingService.class);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestinationStation("Mumbai");
		ticket.setSourceStation("Hyderabad");
		ticket.setPassengerName("vijay");
		ticket.seteMail("vijumca@gmail.com");

		ticketBookingService.createTicket(ticket);
		System.out.println("DAtaSource:" + dataSource.getConnection().toString());
*/
	}

}
