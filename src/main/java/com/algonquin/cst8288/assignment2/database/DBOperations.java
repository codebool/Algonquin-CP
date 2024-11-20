/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.KidsStorytimeEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;
import com.algonquin.cst8288.assignment2.event.WorkshopEvent;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

	private Connection connection;

	public DBOperations() {
		// Initialize the DB connection using DBConnection class
		connection = DBConnection.getInstance().getConnection();
	}

	// CREATE operation: Insert an Event into the database
	public boolean createEvent(Event event) {
		String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
		// Insert the Event data into the database
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, event.getEventName());
			preparedStatement.setString(2, event.getEventDescription());
			preparedStatement.setString(3, event.getEventActivities());
			preparedStatement.setBigDecimal(4, event.getAdmissionFees());
			int rowsInserted = preparedStatement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// RETRIEVE operation: Fetch an Event from the database by ID
	public Event getEventById(int eventId) {
		String sql = "SELECT * FROM events WHERE event_id = ?";
		// Retrieve the Event data from the database
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, eventId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Check if the result set is not empty
			if (resultSet.next()) {
				String name = resultSet.getString("event_name");
				String description = resultSet.getString("event_description");
				String activities = resultSet.getString("event_activities");
				BigDecimal admissionFees = resultSet.getBigDecimal("admission_fees");

				// Create an Event object using the retrieved data
				switch (name) {
					case "Workshop":
						return new WorkshopEvent(name, description, activities, admissionFees);
					case "Movienight":
						return new MovieNightEvent(name, description, activities, admissionFees);
					case "KidsStorytime":
						return new KidsStorytimeEvent(name, description, activities, admissionFees);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// UPDATE operation: Update an existing Event in the database
	public boolean updateEvent(int eventId, Event updatedEvent) {
		String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, updatedEvent.getEventName());
			preparedStatement.setString(2, updatedEvent.getEventDescription());
			preparedStatement.setString(3, updatedEvent.getEventActivities());
			preparedStatement.setBigDecimal(4, updatedEvent.getAdmissionFees());
			preparedStatement.setInt(5, eventId);
			int rowsUpdated = preparedStatement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// DELETE operation: Remove an Event from the database by ID
	public boolean deleteEvent(int eventId) {
		String sql = "DELETE FROM events WHERE event_id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, eventId);
			int rowsDeleted = preparedStatement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// RETRIEVE ALL Events: Fetch all Events from the database
	public List<Event> getAllEvents() {
		String sql = "SELECT * FROM events";
		List<Event> events = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String name = resultSet.getString("event_name");
				String description = resultSet.getString("event_description");
				String activities = resultSet.getString("event_activities");
				BigDecimal admissionFees = resultSet.getBigDecimal("admission_fees");

				// Create an Event object using the retrieved data

				// Create an Event object using the retrieved data
				switch (name) {
					case "Workshop":
						events.add(new WorkshopEvent(name, description, activities, admissionFees));
					case "Movienight":
						events.add(new MovieNightEvent(name, description, activities, admissionFees));
					case "KidsStorytime":
						events.add(new KidsStorytimeEvent(name, description, activities, admissionFees));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
}

