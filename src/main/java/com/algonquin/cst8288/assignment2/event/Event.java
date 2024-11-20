/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

import java.math.BigDecimal;

// Abstract class to represent an Event
public abstract class Event {

    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected BigDecimal admissionFees;

    public Event() {
    }

    public Event(String eventName, String eventDescription, String eventActivities, BigDecimal admissionFees) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventActivities = eventActivities;
        this.admissionFees = admissionFees;
    }


    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }


    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    /**
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }


    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


    /**
     * @return the eventActivities
     */
    public String getEventActivities() {
        return eventActivities;
    }


    /**
     * @param eventActivities the eventActivities to set
     */
    public void setEventActivities(String eventActivities) {
        this.eventActivities = eventActivities;
    }


    /**
     * @return the admissionFees
     */
    public BigDecimal getAdmissionFees() {
        return admissionFees;
    }


    /**
     * @param admissionFees the admissionFees to set
     */
    public void setAdmissionFees(double admissionFees) {
        this.admissionFees = BigDecimal.valueOf(admissionFees);
    }


    // Every library as it own admission fee
    public abstract void calculateAdmissionFee();
}
