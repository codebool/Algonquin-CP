/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import java.math.BigDecimal;

// Class to represent a MovieNightEvent
public class MovieNightEvent extends Event {
    public MovieNightEvent(String eventName, String eventDescription, String eventActivities, BigDecimal admissionFees) {
        super(eventName, eventDescription, eventActivities, admissionFees);
    }

    // Constructor
    public MovieNightEvent() {
        super();
    }

    // Method to calculate the admission fee for the Movie Night Event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BigDecimal.valueOf(Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION);
    }
}
