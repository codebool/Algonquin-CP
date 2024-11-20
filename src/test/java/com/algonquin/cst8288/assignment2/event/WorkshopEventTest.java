package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class WorkshopEventTest extends TestCase {

    public void testCalculateAdmissionFee() {
        WorkshopEvent event = new WorkshopEvent();
        event.calculateAdmissionFee();
        BigDecimal expectedFee = BigDecimal.valueOf(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION);
        assertEquals(expectedFee, event.getAdmissionFees());
    }
}