package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import junit.framework.TestCase;

import java.sql.Connection;

public class DBConnectionTest extends TestCase {
    private LMSLogger logger = LMSLogger.getInstance();

    public void testGetInstance() {
        logger.log(LogLevel.INFO, "Starting testGetInstance");
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();
        assertNotNull(instance1);
        assertSame(instance1, instance2);
        logger.log(LogLevel.INFO, "testGetInstance passed");
    }

    public void testGetConnection() {
        logger.log(LogLevel.INFO, "Starting testGetConnection");
        DBConnection instance = DBConnection.getInstance();
        Connection connection = instance.getConnection();
        assertNotNull(connection);
        logger.log(LogLevel.INFO, "testGetConnection passed");
    }
}