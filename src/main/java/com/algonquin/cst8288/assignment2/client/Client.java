/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.*;
import java.math.BigDecimal;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		DBOperations dbOperations = new DBOperations();

		// Create events
		System.out.println("Creating events...");
		Event workshopEvent = new WorkshopEvent("Workshop", "Hands-on workshop", "Craft activities", new BigDecimal("20.00"));
		Event movieNightEvent = new MovieNightEvent("Movienight", "Fun movie night", "Watching animated films", new BigDecimal("15.00"));
		Event kidsStorytimeEvent = new KidsStorytimeEvent("KidsStorytime", "Storytelling for kids", "Interactive stories", new BigDecimal("10.00"));

		dbOperations.createEvent(workshopEvent);
		dbOperations.createEvent(movieNightEvent);
		dbOperations.createEvent(kidsStorytimeEvent);

		// Retrieve event by ID
		System.out.println("\nRetrieving an event by ID...");
		Event retrievedEvent = dbOperations.getEventById(1);
		if (retrievedEvent != null) {
			System.out.println("Retrieved Event: " + retrievedEvent);
		} else {
			System.out.println("No event found with the given ID.");
		}

		// Update event
		System.out.println("\nUpdating an event...");
		kidsStorytimeEvent.setEventDescription("Updated storytelling session for kids");
		dbOperations.updateEvent(3, kidsStorytimeEvent);

		// Retrieve all events
		System.out.println("\nRetrieving all events...");
		List<Event> allEvents = dbOperations.getAllEvents();
		for (Event event : allEvents) {
			System.out.println(event);
		}

		// Delete an event
		System.out.println("\nDeleting an event...");
		boolean isDeleted = dbOperations.deleteEvent(2); // Delete the event with ID 2
		if (isDeleted) {
			System.out.println("Event deleted successfully.");
		} else {
			System.out.println("Failed to delete event.");
		}

		// Retrieve all events after deletion
		System.out.println("\nRetrieving all events after deletion...");
		List<Event> remainingEvents = dbOperations.getAllEvents();
		for (Event event : remainingEvents) {
			System.out.println(event);
		}
	}
}
