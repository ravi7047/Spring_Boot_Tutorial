package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets")  //http://localhost:8080/tickets

//http://localhost:8080/tickets ==> TicketController ticketObj=ioc.getTicketController();
public class TicketController {

	/*
	 *
	 *  Rest Services are part of WebService.
	 *
	 *  WebService ==> Heterogenious Communication
	 *
	 *  In Java, webservices are of two types ==> 1) SOAP 2) REST
	 *
	 * in SOAP based services , we have complexicity in data format,protocol,contract,proxy,stub
	 *
	 * REST Based Services ==> It uses normal HTTP Protocol and normal HTTP Method like GET,POST,PUT,DELETE will suffice
	 *
	 * @RestController ==> @Rest Protocol + @ Controller (Spring Controller)
	 *
	 *
	 * Get ===> @Get + @RequestMapping ==> @GetMapping
	 * Create ==> @Post + @RequestMapping ==> @PostMapping
	 * Update ==> @Put + @RequestMapping ==> @PutMapping
	 * Delete ==> @Delete + @RequestMapping ==> @DeleteMapping
	 *
	 * By default Rest Services uses JSON Object as communcation
	 *
	 * JSON ==> Javascript Object Notation ==> {
	 *
	 * 												key1:value1,
	 * 												key2:value2,
	 * 												key3:value3
	 * 												address:[
	 * 															 tempaddres:{
	 *
	 * 																		}
	 * 															 permaddress:{
	 * 																		  }
	 *
	 * 														]
	 *
	 *                                         }
	 *
	 *  Developer no need to write code in converting java object to JSON and JSON object to JAVA
	 *  It internally uses JACKSON Library for converting JSON to Java and JAVA to JSON
	 *
	 */


	@Autowired
	private TicketService ticketService;

	///GetAllTickets
	@GetMapping(value="/admin/all")   //http://localhost:8080/tickets/admin/all

	 //http://localhost:8080/tickets/admin/all ==> ticketObj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){

		return ticketService.getAllTickets();

	}




	//Retrieving Single Ticket
	//http://localhost:8080/tickets/ticket/1 ==> 1st Ticket
	//http://localhost:8080/tickets/ticket/100 ==> 100th Ticket
	//{ } ==> Dynamic Variable
	//@PathVariable ==> Annotation which is reading the value from URL
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.RetrieveTicket(ticketId);
	}

	//Delete Ticket
	@DeleteMapping(value="/{ticketId}")
	//http://localhost:8080/tickets/1 ==>1st ticket
	//http://localhost:8080/tickets/100 ==> 100th Ticket
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		 ticketService.deleteTicket(ticketId);
	}


	//Create Ticket
	@PostMapping(value="/create")
	//http://localhost:8080/tickets/create
   //@RequestBody ==> Entire Ticket.json exists in Body Section
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}


	//Update Ticket
	//http://localhost:8080/tickets/1/vijay@yahoo.com ==> 1st Ticket
	//http://localhost:8080/tickets/100/ramu@yahoo.com ==> 100th Ticket
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket udpateTicket(
			@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}



}
