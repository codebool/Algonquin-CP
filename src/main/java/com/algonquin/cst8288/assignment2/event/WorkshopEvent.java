/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment
 */

package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import java.math.BigDecimal;

// WorkshopEvent class extends Event
public class WorkshopEvent extends Event {
    // Constructor with parameters
    public WorkshopEvent(String eventName, String eventDescription, String eventActivities, BigDecimal admissionFees) {
        super(eventName, eventDescription, eventActivities, admissionFees);
    }

    // Constructor
    public WorkshopEvent() {
        super();
    }

    // Method to calculate the admission fee for the Workshop Event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BigDecimal.valueOf(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION);
    }
}
