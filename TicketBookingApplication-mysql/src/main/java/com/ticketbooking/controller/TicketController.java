package com.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ticketbooking.model.Ticket;
import com.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value = "/tickets") // http://localhost:8080/tickets
//http://localhost:8080/tickets ==> TicketController ticketCont=ioc.getTicketController();
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	
	/*
	 * JAX RS => JAVA API FOR REST SERVICES ==> WEBSERVICE
	 *
	 * WEBSERVICE ==> TWO DIFFERENT PROGRAMMING LANAGUAGES WANT TO COMMUNICATE
	 *
	 * WEBSERVICES ==> SOAP AND REST
	 *
	 * REST ==> IT WORKS ON NORMAL HTTP PROTOCOL
	 *
	 * GET VERB ==> GET OPERATION ==> @Get+ @RequestMapping==> @GetMapping 
	 * POST VERB==> CREATE OPERATION ==> @Post + @RequestMapping==> @PostMapping 
	 * PUT VERB ==> UPDATE OPERATION ==>@Put + @RequestMapping==> @PutMapping 
	 * DELETE VERB ==>DELETE OPERATION ==>@Delete + @RequestMapping ==> @DeletetMapping
	 *
	 * DEFAULT COMMUNICATION ==> JSON ==> javaScript Object ==> { key and value} {
	 * "passengerName" : "vijay"}
	 *
	 * It has an internal libarary ==> JACKSON LIBRARY ==> JAVA TO JSON AND JSON TO
	 * JAVA
	 *
	 *
	 *
	 */
	@GetMapping(value = "/all") // http://localhost:8080/tickets/all
	// http://localhost:8080/tickets/all ==> ticketCont.getAllTickets();
	public Iterable<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}
	
	
	
	        // Create Ticket
			@PostMapping(value = "/create") // http://localhost:8080/tickets/create
			// http://localhost:8080/tickets/create==> ticketCont.createTicket();
			
			public Ticket createTicket(@RequestBody Ticket ticketObj)
			{
				return ticketService.createTicket(ticketObj);
			}
			
			// Get a invidivual Ticket
			@GetMapping(value= "/{ticketId}") // { } ==> Dynamic Variable
			//http://localhost:8080/tickets/1  ==> ticketCont.getTicket(1)
		    //http://localhost:8080/tickets/100 ==> ticketCont.getTicket(100)
		    //http://localhost:8080/tickets/2 ==> ticketCont.getTicket(2);
			public Ticket getTicket(@PathVariable ("ticketId") Integer ticketId) 
			{
			return ticketService.getTicket(ticketId);
			}
			
			//Delete Ticket
			@DeleteMapping(value="/{ticketId}") // { } ==> Dynamic Variable
			//http://localhost:8080/tickets/1  ==> ticketCont.deleteTicket(1)
		    //http://localhost:8080/tickets/100 ==> ticketCont.deleteTicket(100)
		    //http://localhost:8080/tickets/2 ==> ticketCont.deleteTicket(2);
			public void deleteTicket(@PathVariable ("ticketId") Integer ticketId)
			{
				ticketService.deleteTicket(ticketId);
			}
			
			//UpdateTicket
			@PutMapping(value="/{ticketId}/{newEmail}")
			//http://localhost:8080/1/a@b.com ==>ticketCont.updateTicket
			public Ticket  updateTicket(@PathVariable ("ticketId") Integer ticketId,@PathVariable ("newEmail") String newEmail )
			{
				return ticketService.updateTicket(ticketId, newEmail);
			}	

}
