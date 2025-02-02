package com.ticketbooking.dao;

import org.apache.catalina.CredentialHandler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.model.Ticket;

@Repository
/*
 * @Repository==> It will automatially crates a database connection
 * DriverManager.getconection()....Connction.open. PreparedSatement, ExecuteSql,
 * Result set
 *
 */
public interface TicketDao extends CrudRepository<Ticket, Integer>  {

	/*
	 * Every table in database ==> CRUD OPERATIONS ==>
	 *
	 * C ==> CREATE ==> INSERT R ==> READ ==> SELECT U ==> UPDATE ==> UPDATE D ==>
	 * DELETE ==> DELETE
	 *
	 *
	 * CRUD REPOSITORY IS PROVIDED BY FRAMEWORK TO ACHIEVE CRUD OPERATIONS
	 *
	 * It has two parameters 1) Model Class Name 2) Data Type of Primary Key
	 */
}
