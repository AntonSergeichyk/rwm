package com.example.inhouse.rwm.demo.model.timetable;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddOrUpdateTimeTableRequest {

    private Long stationId;
    private Long trainId;
    private String arrivalTime;
}
