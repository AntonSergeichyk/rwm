package com.example.inhouse.rwm.demo.model.timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TimeTableDto {

    private Long trainId;
    private Integer trainNumber;
    private String trainName;
    private LocalDateTime departureTime;
    private String departureStationName;
    private LocalDateTime arrivalTime;
    private String arrivalStationName;
}
