/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-10-21
 * Modified: 2024-10-21
 * Description: Lab assignment 02
 */

package org.cst8288Lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// ValidatorTest class
class ValidatorTest {
    // Test the validateStudentId method
    @Test
    void validateStudentId() {
        assertTrue(Validator.validateStudentId("123456789"));
        assertFalse(Validator.validateStudentId("12345"));
        assertFalse(Validator.validateStudentId("1234567890"));
        assertFalse(Validator.validateStudentId("abcdefghi"));
    }

    // Test the validateCourseId method
    @Test
    void validateCourseId() {
        assertTrue(Validator.validateCourseId("abc1234"));
        assertTrue(Validator.validateCourseId("ABC1234"));
        assertFalse(Validator.validateCourseId("ab1234"));
        assertFalse(Validator.validateCourseId("abcd1234"));
        assertFalse(Validator.validateCourseId("abc12345"));
    }

    // Test the validateTerm method
    @Test
    void validateTerm() {
        assertTrue(Validator.validateTerm("WINTER"));
        assertTrue(Validator.validateTerm("SUMMER"));
        assertTrue(Validator.validateTerm("FALL"));
        assertTrue(Validator.validateTerm("winter"));
        assertFalse(Validator.validateTerm("SPRING"));
    }

    // Test the convertTerm method
    @Test
    void convertTerm() {
        assertEquals(1, Validator.convertTerm("WINTER"));
        assertEquals(2, Validator.convertTerm("SUMMER"));
        assertEquals(3, Validator.convertTerm("FALL"));
        assertThrows(IllegalArgumentException.class, () -> Validator.convertTerm("SPRING"));
    }

    // Test the validateYear method
    @Test
    void validateYear() {
        assertFalse(Validator.validateYear(1962)); // date before Algonquin College was founded
        assertTrue(Validator.validateYear(2023));
        assertTrue(Validator.validateYear(1968));
        assertTrue(Validator.validateYear(2024));
    }
}