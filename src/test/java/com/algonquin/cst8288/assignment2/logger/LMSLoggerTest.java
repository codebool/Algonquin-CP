package com.algonquin.cst8288.assignment2.logger;

import junit.framework.TestCase;

public class LMSLoggerTest extends TestCase {

    public void testGetInstance() {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();
        assertNotNull(logger1);
        assertSame(logger1, logger2);
    }

    public void testLog() {
        LMSLogger logger = LMSLogger.getInstance();
        logger.log(LogLevel.INFO, "This is an info message.");
        logger.log(LogLevel.ERROR, "This is an error message.");
    }

    public void testTestLog() {
        LMSLogger logger = LMSLogger.getInstance();
        Exception exception = new Exception("Test exception");
        logger.log(LogLevel.ERROR, "This is an error message with exception.", exception);
    }
}