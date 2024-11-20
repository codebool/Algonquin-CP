package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class MovieNightEventTest extends TestCase {

    public void testCalculateAdmissionFee() {
        MovieNightEvent event = new MovieNightEvent();
        event.calculateAdmissionFee();
        BigDecimal expectedFee = BigDecimal.valueOf(Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION);
        assertEquals(expectedFee, event.getAdmissionFees());
    }
}