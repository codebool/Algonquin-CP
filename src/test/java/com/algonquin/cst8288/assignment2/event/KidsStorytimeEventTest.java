package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class KidsStorytimeEventTest extends TestCase {

    public void testCalculateAdmissionFee() {
        KidsStorytimeEvent event = new KidsStorytimeEvent();
        event.calculateAdmissionFee();
        BigDecimal expectedFee = BigDecimal.valueOf(Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION);
        assertEquals(expectedFee, event.getAdmissionFees());
    }
}