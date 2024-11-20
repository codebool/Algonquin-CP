/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

// Factory class to create EventCreators
public class EventFactory {
    private static LMSLogger logger = LMSLogger.getInstance();

    public static EventCreator getEventCreator(EventType eventType) {
        switch (eventType) {
            case KIDS_STORY:
                logger.log(LogLevel.INFO, "Creating KidsStorytimeEventCreator.");
                return new KidsStorytimeEventCreator();
            case MOVIE_NIGHT:
                logger.log(LogLevel.INFO, "Creating MovieNightEventCreator.");
                return new MovieNightEventCreator();
            case WORKSHOP:
                logger.log(LogLevel.INFO, "Creating WorkshopEventCreator.");
                return new WorkshopEventCreator();
            default:
                logger.log(LogLevel.ERROR, "Unknown event type: " + eventType);
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}
