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

// Class to represent a Kids Storytime Event
public class KidsStorytimeEvent extends Event {
    public KidsStorytimeEvent(String eventName, String eventDescription, String eventActivities, BigDecimal admissionFees) {
        super(eventName, eventDescription, eventActivities, admissionFees);
    }

    // Constructor
    public KidsStorytimeEvent() {
        super();
    }

    // Method to calculate the admission fee for the Kids Storytime Event
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BigDecimal.valueOf(Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION);
    }

    // Method to return the string representation of the Kids Storytime Event
    public String toString() {
        System.out.println("Kids Storytime Event");
        return null;
    }
}
