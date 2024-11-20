/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

package com.algonquin.cst8288.assignment2.logger;

import junit.framework.TestCase;

// Test class for LMSLogger
public class LMSLoggerTest extends TestCase {
    // Test method for getInstance()
    public void testGetInstance() {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();
        assertNotNull(logger1);
        assertSame(logger1, logger2);
    }

    // Test method for log()
    public void testLog() {
        LMSLogger logger = LMSLogger.getInstance();
        logger.log(LogLevel.INFO, "This is an info message.");
        logger.log(LogLevel.ERROR, "This is an error message.");
    }

    // Test method for log() with exception
    public void testTestLog() {
        LMSLogger logger = LMSLogger.getInstance();
        Exception exception = new Exception("Test exception");
        logger.log(LogLevel.ERROR, "This is an error message with exception.", exception);
    }
}