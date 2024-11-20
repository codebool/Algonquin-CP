/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import junit.framework.TestCase;
import java.math.BigDecimal;

// Test WorkshopEvent
public class WorkshopEventTest extends TestCase {
    // Test calculateAdmissionFee
    public void testCalculateAdmissionFee() {
        WorkshopEvent event = new WorkshopEvent();
        event.calculateAdmissionFee();
        BigDecimal expectedFee = BigDecimal.valueOf(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION);
        assertEquals(expectedFee, event.getAdmissionFees());
    }
}