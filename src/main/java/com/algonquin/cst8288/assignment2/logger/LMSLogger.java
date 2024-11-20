/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-19
 * Modified: 2024-11-19
 * Description: Lab assignment 2
 */

// src/main/java/com/algonquin/cst8288/assignment2/logger/LMSLogger.java
package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Logger class to log messages
public class LMSLogger {
    private static LMSLogger instance;
    private PrintWriter writer;

    // Private constructor to prevent instantiation
    private LMSLogger() {
        try {
            FileWriter fileWriter = new FileWriter("Assignment2_BoQu.log", true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the singleton instance of LMSLogger
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    // Log a message with a given log level
    public void log(LogLevel level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        writer.println(timestamp + " [" + level + "] " + message);
    }

    // Log a message with a given log level and throwable
    public void log(LogLevel level, String message, Throwable throwable) {
        log(level, message);
        throwable.printStackTrace(writer);
    }
}
