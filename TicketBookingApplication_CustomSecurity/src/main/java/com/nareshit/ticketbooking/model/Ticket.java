package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 1) Every Java Class is  a table
 * 2) Every Java Propety is a databae column
 * 3) Every Java Instance is Database Row
 */

@Entity //Which will create a table to database, Default Table Name is Java Class Name
@Table(name = "tbl_ticket") //This Annotation is going to rename the Ticket table to tbl_ticket
public class Ticket {


	//Every Table Should have Primary Key
	//FOR ORM Frameworks Primary Key is mandatory
	//Primary Key should be system generated to maintain the uniqueness rather than userinput
	// AUTO AND IDENTITY are the two options in ORM Framework
	// AUTO ==> JPA Framework will create a database sequence to DB and it will increment while inserting the record
	//@Id ==> Primary Key

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;


	@Column(name = "passenger_name") //This annotation will renames the java property name to databae naning convetions
	private String passengerName;


	@Column(name = "travel_date")
	private Date travelDate;

	@Column(name = "source_Station")
	private String sourceStation;

	@Column(name = "destination_station")
	private String destinationStation;

	private String email;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket() {}

	public Ticket(Integer ticketId, String passengerName, Date travelDate, String sourceStation,
			String destinationStation, String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.travelDate = travelDate;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", travelDate=" + travelDate
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", email=" + email
				+ "]";
	}






}
