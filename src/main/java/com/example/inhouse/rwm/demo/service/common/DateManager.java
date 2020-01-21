package com.example.inhouse.rwm.demo.service.common;

import com.example.inhouse.rwm.demo.common.exception.DateParseException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateManager {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d-MM-yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm:ss");

    public static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new DateParseException(date + " could not be parsed; expected format: d-MM-yyyy");
        }
    }

    public static LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new DateParseException(dateTime + " could not be parsed; expected format: d-MM-yyyy HH:mm:ss");
        }
    }

    public static LocalDate getDate(LocalDateTime dateTime){
        return dateTime.toLocalDate();
    }
}
