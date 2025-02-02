package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dao.TicketDao;
import com.ticketbooking.model.Ticket;

@Service
/*
 *  It will be adding the capabilities of service layer like transaction mgmt,logging and external components
 */
public class TicketService {
	
	/*
	 *  Create Ticket, UpdateTicket,DeleteTicket,GetAllTickets and GetTicket
	 */


	@Autowired
	private TicketDao ticketDao; //TicketDao ticketDao=new TicketDao();
	
	//GetAllTickets
	public Iterable<Ticket> getAllTickets()
	{
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket
	}

	//Create Ticket 
	public Ticket createTicket(Ticket ticketObj) {
		return ticketDao.save(ticketObj);
		/*save ==> Insert the data ==> insert into tbl_ticket values (...);
		 * Save Method will perform insert and update also
		 * if ticketObj.ticketid ==> is null where developer is not passing ==> insert
		 * if ticketObj.ticketid ==> is not null where developer is passing this value ==> if the value
		 *                            is not there ==> insert
		 * if ticketObj.ticketid ==> is not null where developer is passing this value ==> if the value
		 *                            is  there ==> update
		 */
	}
	
	//Getting a particualr Ticket
	public Ticket getTicket(Integer ticketId) {
		return ticketDao.findById(ticketId).orElse(new Ticket());

		//findById ==> Retrieving the data with where condition
		//         ==> select * from tbl_ticket where ticket_id=ticketId
	}
	
	//Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);

		//deleteById ==> delete from tbl_ticket where ticket_id=ticketId
	}
	
	//Update the Ticket
		public Ticket updateTicket(Integer ticketId,String newEmail) {

			Ticket dbTicketObj=getTicket(ticketId);
			dbTicketObj.setEmail(newEmail);
			return ticketDao.save(dbTicketObj);
			//save ==> update tbl_ticket set email=newEmail where ticket_id=ticketId

		}
}
