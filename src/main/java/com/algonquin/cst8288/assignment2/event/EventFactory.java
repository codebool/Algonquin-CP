/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

public class EventFactory {
    public static EventCreator getEventCreator(EventType eventType) {
        switch (eventType) {
            case KIDS_STORY:
                return new KidsStorytimeEventCreator();
            case MOVIE_NIGHT:
                return new MovieNightEventCreator();
            case WORKSHOP:
                return new WorkshopEventCreator();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}
