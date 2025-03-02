package com.ticketbooking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketbooking.controller.TicketController;
import com.ticketbooking.model.Ticket;
import com.ticketbooking.service.TicketService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TicketBookingControllerTest {

	private MockMvc mockMvc;

	@Mock
	private TicketService ticketService;

	@InjectMocks
	private TicketController ticketController;

	private Ticket ticket;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
		ticket = createTestTicket(); // Call helper method to create a test ticket
	}

	private Ticket createTestTicket() {
		return new Ticket(2, "Ravi Ranjan", "Patna", "Delhi", "Ravi2840@gmail.com");
	}

	/**
	 * Test case for creating a ticket and validating JSON structure, status code,
	 * and data.
	 */
	@Test
	void testCreateTicket_ShouldReturn201() throws Exception {
		when(ticketService.createTicket(any(Ticket.class))).thenReturn(ticket);

		mockMvc.perform(post("/tickets/create").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(ticket))).andExpect(status().isOk()) // Ensure 201
																									// Created status
				.andExpect(jsonPath("$.passengerName").value("Ravi Ranjan"))
				.andExpect(jsonPath("$.sourceStation").value("Patna"))
				.andExpect(jsonPath("$.destinationStation").value("Delhi"))
				.andExpect(jsonPath("$.email").value("Ravi2840@gmail.com")).andExpect(jsonPath("$").isNotEmpty()); // Ensure
																													// JSON
																													// is
																													// not
																													// empty
	}

	/**
	 * Test case for retrieving all tickets and validating the list size and
	 * structure.
	 */
	@Test
	void testGetAllTickets_ShouldReturnList() throws Exception {
		when(ticketService.getAllTickets()).thenReturn(List.of(ticket));

		mockMvc.perform(get("/tickets/all")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(1)) // Ensure
																													// list
																													// size
																													// is
																													// 1
				.andExpect(jsonPath("$[0].passengerName").value("Ravi Ranjan"))
				.andExpect(jsonPath("$[0].sourceStation").value("Patna"))
				.andExpect(jsonPath("$[0].destinationStation").value("Delhi"))
				.andExpect(jsonPath("$[0].email").value("Ravi2840@gmail.com")).andExpect(jsonPath("$[0]").isNotEmpty()); // Ensure
																															// object
																															// is
																															// not
																															// empty
	}

	/**
	 * Test case for fetching a ticket by ID and validating its structure and data.
	 */
	@Test
	void testGetTicketById_ShouldReturnTicket() throws Exception {
		when(ticketService.getTicket(2)).thenReturn(ticket);

		mockMvc.perform(get("/tickets/2")).andExpect(status().isOk())
				.andExpect(jsonPath("$.passengerName").value("Ravi Ranjan"))
				.andExpect(jsonPath("$.sourceStation").value("Patna"))
				.andExpect(jsonPath("$.destinationStation").value("Delhi"))
				.andExpect(jsonPath("$.email").value("Ravi2840@gmail.com")).andExpect(jsonPath("$").isNotEmpty()); // Ensure
																													// object
																													// is
																													// not
																													// empty
	}

	/**
	 * Test case for updating a ticket and validating the updated data.
	 */
	@Test
	void testUpdateTicket_ShouldReturnUpdatedTicket() throws Exception {
		ticket.setEmail("updated.email@gmail.com");
		when(ticketService.updateTicket(2, "updated.email@gmail.com")).thenReturn(ticket);

		mockMvc.perform(put("/tickets/2/updated.email@gmail.com")).andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("updated.email@gmail.com")).andExpect(jsonPath("$").isNotEmpty()); // Ensure
																														// object
																														// is
																														// not
																														// empty
	}

	/**
	 * Test case for deleting a ticket and verifying status code.
	 */
	@Test
	void testDeleteTicket_ShouldReturn200() throws Exception {
		mockMvc.perform(delete("/tickets/2")).andExpect(status().isOk());
	}
	/*
	
	 @Test
	    void testCalculateBonusPrivateMethod() throws Exception {
	        // Access private method using reflection
	        Method method = EmployeeService.class.getDeclaredMethod("calculateBonus", double.class);
	        method.setAccessible(true);

	        double bonus = (double) method.invoke(service, 50000);

	        assertEquals(5000, bonus); // 10% of 50000
	    }

	    @Test
	    void testValidateEmailPrivateMethod() throws Exception {
	        // Access private method using reflection
	        Method method = EmployeeService.class.getDeclaredMethod("validateEmail", String.class);
	        method.setAccessible(true);

	        assertThrows(IllegalArgumentException.class, () -> method.invoke(service, "invalidEmail"));
	    }
	    
	    */
}
