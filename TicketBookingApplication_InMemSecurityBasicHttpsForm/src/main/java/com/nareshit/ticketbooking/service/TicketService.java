package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

/*
 *
 * Business Logic ==> Service Layer and also Transaction Management
 */

@Service
public class TicketService {



     @Autowired
     private TicketDao ticketDao; ///TicketDao ticketDao=new TicketDao();



     //Create Ticket

     public Ticket createTicket(Ticket ticketObj) {
    	 return ticketDao.save(ticketObj);
    	 //Save method is for inserting and updating

    	 /*
    	  * If Ticketobj.ticketId === null (no value ) ==> insert
    	  *    Ticketobj.ticketId ==> Some Value ==> Not there in the database ==> insert
    	  *
    	  *    TicketObj.ticketId ==> Some Value ==> Exists in the database ==> Update
    	  *
    	  */

     }


     //Retrieve All Tickets

     public Iterable<Ticket> getAllTickets(){
    	 return ticketDao.findAll();
    	 //findAll ==> select * from tbl_ticket

     }



     //Retrieve Specific Ticket

     public Ticket RetrieveTicket(Integer ticketId) {

    	 return ticketDao.findById(ticketId).orElse(new Ticket());

    	// findById  ==> select * from tbl_ticket where ticket_id=ticketId
     }


     //Delete Ticket

     public void deleteTicket(Integer ticketId) {
    	 ticketDao.deleteById(ticketId);
    	 //deleteById ==> delete from tbl_ticket where ticket_id=ticketId
     }

     //Update Ticket

     public Ticket updateTicket(Integer ticketId,String newEmail) {

    	 Ticket dbTicketObj=RetrieveTicket(ticketId);
    	 dbTicketObj.setEmail(newEmail);
    	 return ticketDao.save(dbTicketObj);

    	 //Here save method will update since dbTicketObj.ticketid==exists in the database


     }
}
