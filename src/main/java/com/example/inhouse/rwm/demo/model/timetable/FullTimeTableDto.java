package com.example.inhouse.rwm.demo.model.timetable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class FullTimeTableDto {

    private Long trainId;
    private Integer trainNumber;
    private String trainName;
    private LocalDateTime departureTime;
    private String departureStationName;
    private Long departureStationId;
    private LocalDateTime arrivalTime;
    private String arrivalStationName;
    private Long arrivalStationId;
}
