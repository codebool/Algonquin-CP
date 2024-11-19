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

public class KidsStorytimeEvent extends Event {
    public KidsStorytimeEvent(String eventName, String eventDescription, String eventActivities, BigDecimal admissionFees) {
        super(eventName, eventDescription, eventActivities, admissionFees);
    }

    public KidsStorytimeEvent() {
        super();
    }

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = BigDecimal.valueOf(Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION);
    }

    public String toString() {
        System.out.println("Kids Storytime Event");
        return null;
    }
}
