/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

public class MovieNightEventCreator extends EventCreator {
    @Override
    public Event createEvent() {
        return new MovieNightEvent();
    }
}
