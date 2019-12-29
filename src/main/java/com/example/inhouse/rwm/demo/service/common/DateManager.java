package com.example.inhouse.rwm.demo.service.common;

import com.example.inhouse.rwm.demo.common.exception.DateParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateManager {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public static LocalDate parse(String date) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new DateParseException(date + " could not be parsed; expected format: d/MM/yyyy");
        }
    }
}
