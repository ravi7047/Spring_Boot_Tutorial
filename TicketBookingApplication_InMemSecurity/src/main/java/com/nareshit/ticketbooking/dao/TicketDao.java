package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

/*
 * DAO ==> Data access Object
 * We need to connect database and DriverManager.getConnection, connection.open...and we need to use insert statment,udpate..
 * execute update......PreparedStatements===> Alll these are automated by spring boot with @Repository
 *
 *
 * CRUDRepository==> C ==> CREATE (INSERT), R ==> READ , U ==> UPDATE , D ==> DELETE
 *                  ==> Two Input Parmaeters ==> 1) Java class Name 2) Data type of Primary Key
 */

@Repository
public interface TicketDao  extends CrudRepository<Ticket, Integer>{


/*
 *
 * TicketDao ==> 4 Methods
 *
 * 1) save ==> Insert and Update ==> TicketDao.save() ==> insert into or update
 * 2) Retrieve All ==> TicketDao.findAll() ==> select * from ticket
 * 3) Retrieve Specific Record ==> TicketDao.findById() => select * from ticket where ticket_id=?
 * 4) Delete ==> TicketDao.deleteById ==> delete from ticket where ticket_id=?
 *
 *
 *
 * When we have more than one record is available ==> CRUD REPOSITORY  PROVIDES COLLECTION DATASTRUCTUES AS INPUT AND OUTPUT
 *
 * 5) SaveAll ==> Input is Iterable<Entity> and Outuput is Iterable<Entity>
 * 6) findAlById ==> Input is  (Iterable<PKVALUES>) and outPut is Iterable<Entity>
 *
 */

}
