package org.cst8288Lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validateStudentId() {
        assertTrue(Validator.validateStudentId("123456789"));
        assertFalse(Validator.validateStudentId("12345"));
        assertFalse(Validator.validateStudentId("1234567890"));
        assertFalse(Validator.validateStudentId("abcdefghi"));
    }

    @Test
    void validateCourseId() {
        assertTrue(Validator.validateCourseId("abc1234"));
        assertTrue(Validator.validateCourseId("ABC1234"));
        assertFalse(Validator.validateCourseId("ab1234"));
        assertFalse(Validator.validateCourseId("abcd1234"));
        assertFalse(Validator.validateCourseId("abc12345"));
    }

    @Test
    void validateTerm() {
        assertTrue(Validator.validateTerm("WINTER"));
        assertTrue(Validator.validateTerm("SUMMER"));
        assertTrue(Validator.validateTerm("FALL"));
        assertTrue(Validator.validateTerm("winter"));
        assertFalse(Validator.validateTerm("SPRING"));
    }

    @Test
    void convertTerm() {
        assertEquals(1, Validator.convertTerm("WINTER"));
        assertEquals(2, Validator.convertTerm("SUMMER"));
        assertEquals(3, Validator.convertTerm("FALL"));
        assertThrows(IllegalArgumentException.class, () -> Validator.convertTerm("SPRING"));
    }

    @Test
    void validateYear() {
        assertTrue(Validator.validateYear(1967));
        assertTrue(Validator.validateYear(2023));
        assertFalse(Validator.validateYear(1966));
        assertTrue(Validator.validateYear(2024));
    }
}